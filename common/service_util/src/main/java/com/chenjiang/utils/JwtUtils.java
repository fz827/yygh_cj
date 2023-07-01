package com.chenjiang.utils;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Map;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;


import java.util.Date;
import java.util.HashMap;


public class JwtUtils {

    private static final String SECRET_KEY = "your_secret_key";

    public static String generateToken(Map<String, Object> payload, long expirationTimeMillis) {
        long currentTimeMillis = System.currentTimeMillis();
        Date now = new Date(currentTimeMillis);

        JwtBuilder builder = Jwts.builder()
                .setIssuedAt(now)
                .setClaims(payload)
                .signWith(SignatureAlgorithm.HS256, SECRET_KEY);

        // 设置过期时间
        Date expirationDate = new Date(currentTimeMillis + expirationTimeMillis);
        builder.setExpiration(expirationDate);

        return builder.compact();
    }

    public static Map<String, Object> parseToken(String token) {
        Claims claims = Jwts.parser()
                .setSigningKey(SECRET_KEY)
                .parseClaimsJws(token)
                .getBody();

        return new HashMap<>(claims);
    }
}





