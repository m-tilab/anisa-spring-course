package com.example.springbootrest.security;

public class SecurityConstants {

    public static final long EXPIRATION_TIME = 86400000000L;
    public static final String TOKEN_PREFIX = "Bearer ";
    public static final String HEADER_STRING = "Authorization";
    public static final String SIGN_UP_URL = "/user";
    public static final String TOKEN_SECRET = "SpringBoot";

}
