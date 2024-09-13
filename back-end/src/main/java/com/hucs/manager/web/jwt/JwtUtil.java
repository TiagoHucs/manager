package com.hucs.manager.web.jwt;

import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import io.jsonwebtoken.Claims;

import java.security.Key;
import java.util.Date;

public class JwtUtil {
    private static final Key key = Keys.secretKeyFor(SignatureAlgorithm.HS256); // Chave secreta

    public static String generateToken(String username) {
        return Jwts.builder()
                .setSubject(username)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60)) // 1 hora de validade
                .signWith(key)
                .compact();
    }

    //TODO só validar?
    public static Claims validateToken(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(key)
                .build()
                .parseClaimsJws(token)
                .getBody();
    }

    public static String getUsernameFromToken(String token) {
        String username;
        try {
            final Claims claims = validateToken(token);
            username = claims.getSubject();
        } catch (Exception e) {
            username = null;
        }
        return username;
    }

    public Date getExpirationDateFromToken(String token) {
        Date expiration;
        try {
            final Claims claims = validateToken(token);
            expiration = claims.getExpiration();
        } catch (Exception e) {
            expiration = null;
        }
        return expiration;
    }

    private Boolean isTokenExpired(String token) {
        final Date expiration = getExpirationDateFromToken(token);
        if (expiration == null) {
            return true;
        } else {
            return expiration.before(new Date());
        }

    }

    public static boolean isValidToken(String token) {
        try {
            validateToken(token);
        } catch (JwtException e) {
            return false;
        }
        return true;
    }
}
