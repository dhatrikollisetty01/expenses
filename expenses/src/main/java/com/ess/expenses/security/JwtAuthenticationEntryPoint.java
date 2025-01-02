package com.ess.expenses.security;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
@Component
public class JwtAuthenticationEntryPoint extends OncePerRequestFilter {

        private static final Log logger = LogFactory.getLog(JwtAuthenticationEntryPoint.class);

        @Autowired
        private RestTemplate restTemplate;


        @Override
        protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
                throws ServletException, IOException {

            String authHeader = request.getHeader("Authorization");
            String email = request.getHeader("email");

            if (authHeader != null && authHeader.startsWith("Bearer ") && email != null) {
                String token = authHeader.substring(7); // Extract token

                try {
                    // Log the token and email to ensure it's being passed correctly
                    logger.info("Attempting to validate token for email: " + email);

                    // Validate token with the User Management Service
                    String authServiceUrl = "https://enscenter.xyz/admin/api/auth/validateToken";


                    Map<String, String> map = new HashMap<>();
                    map.put("token", token);
                    map.put("email", email);

                    HttpHeaders headers = new HttpHeaders();
                    headers.setContentType(MediaType.APPLICATION_JSON);

                    HttpEntity<Map<String, String>> requestEntity = new HttpEntity<>(map, headers);

                    // Log the request being sent to the User Management Service
                    logger.info("Sending validation request to: " + authServiceUrl + " with token: " + token);

                    ResponseEntity<String> responseEntity = restTemplate.postForEntity(authServiceUrl, requestEntity, String.class);

                    // Log the response from the User Management Service
                    logger.info("Response from validation service: " + responseEntity.getStatusCode() + " - " + responseEntity.getBody());

                    if (responseEntity.getStatusCode() == HttpStatus.OK) {

                        logger.info("Validated token successfully");

                        UsernamePasswordAuthenticationToken authentication =
                                new UsernamePasswordAuthenticationToken(email, token, null);

                        // Set the Authentication object in SecurityContext
                        SecurityContextHolder.getContext().setAuthentication(authentication);

                        logger.info("User details set in SecurityContext for: " + email);


                    } else {
                        logger.error("Failed to validate token. Status code: " + responseEntity.getStatusCode());

                        throw new RuntimeException("Failed to validate token. Status code: " + responseEntity.getStatusCode());
                    }
                } catch (Exception e) {
                    logger.error("Token validation failed", e);

                    response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Token validation failed");
                    return;
                }
            } else {
                logger.warn("Authorization header is missing or invalid");
                System.out.println("Authorization header is missing or invalid");

                response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Authorization header is missing or invalid");
                return;
            }

            filterChain.doFilter(request, response); // Continue with the request
        }
    }
