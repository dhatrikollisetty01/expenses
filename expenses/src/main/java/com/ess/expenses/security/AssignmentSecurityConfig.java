package com.ess.expenses.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableMethodSecurity
@EnableWebSecurity
public class AssignmentSecurityConfig implements WebMvcConfigurer {

        @Autowired
        private JwtAuthenticationEntryPoint jwtAuthFilter;



        // Password Encoder
        @Bean
        public PasswordEncoder passwordEncoder() {
            return new BCryptPasswordEncoder();
        }

        // Security Filter Chain
        @Bean
        public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
            http
                    .csrf(csrf -> csrf.disable()) // Disable CSRF for APIs
                    .cors()
                    .and()
                    .authorizeHttpRequests(auth -> auth
                            .requestMatchers("/api/payment/**").permitAll()
                                    .requestMatchers("/api/receivable/**").permitAll() // Public
                            .anyRequest().authenticated() // All other endpoints are secured
                    )
                    .sessionManagement(sess -> sess
                            .sessionCreationPolicy(SessionCreationPolicy.STATELESS) // Stateless sessions
                    );
            http.addFilterBefore(jwtAuthFilter, UsernamePasswordAuthenticationFilter.class);

            return http.build();
        }

        // CORS Configuration
        @Override
        public void addCorsMappings(CorsRegistry registry) {
            registry.addMapping("/**")
                    .allowedOrigins(
                            "http://localhost:3000",
                            "https://mpkun.com",
                            "mpkun.com",
                            "https://enscenter.xyz",
                            "http://localhost:8081",
                            "http://localhost:8082",
                            "http://localhost:8083",
                            "http://localhost:8084",
                            "http://localhost:8083",
                            "http://localhost:8085",
                            "http://localhost:8086",
                            "http://localhost:8087"

                    )
                    .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS")
                    .allowedHeaders("*")
                    .allowCredentials(true);
        }
    }