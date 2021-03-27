package com.internal.jwtapi.constants;

public class AuthenticationConstants {

        public static final String SECRET = "DevelopmentSecret";
        public static final long EXPIRATION_TIME = 86400000; // 1 days
        public static final String TOKEN_PREFIX = "Bearer ";
        public static final String HEADER_STRING = "Authorization";
        public static final String SIGN_UP_URL = "/api/user";
}


