package com.ess.expenses.security;

import java.util.List;

public class ValidationResponse {
        private boolean valid; // Indicates if the token is valid
        private String username; // Username extracted from the token
        private List<String> permissions; // List of permissions associated with the user

        public ValidationResponse() {
        }

        public ValidationResponse(boolean valid, String username,List<String> permissions) {
            this.valid = valid;
            this.username = username;
            this.permissions=permissions;
        }

        public boolean isValid() {
            return valid;
        }

        public void setValid(boolean valid) {
            this.valid = valid;
        }

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }
        public List<String> getPermissions() {
            return permissions;
        }

        public void setPermissions(List<String> permissions) {
            this.permissions = permissions;
        }
    }