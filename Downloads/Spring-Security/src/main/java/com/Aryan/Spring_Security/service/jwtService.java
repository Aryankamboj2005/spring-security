package com.Aryan.Spring_Security.service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

@Service
public class jwtService {

    private String secretekey;

    // generating the tokens

    public jwtService() {
        try {
            // STEP 1: Create a KeyGenerator for HmacSHA256 (the algorithm we use for signing)
            KeyGenerator keyGenerator = KeyGenerator.getInstance("HmacSHA256");
            // STEP 2: Generate a secure random SecretKey
            SecretKey sk = keyGenerator.generateKey();
            // STEP 3: Convert the SecretKey to a Base64 string for storage in our service
            secretekey = Base64.getEncoder().encodeToString(sk.getEncoded());
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

    public String generateToken(String Username) {

        // STEP 1: Prepare a map for any custom data (claims) we want to put inside the token
        Map<String, Object> claims = new HashMap<>();

        // STEP 2: Start the building process for the JWT
        return Jwts.builder()
                .claims()
                .add(claims) // Add your custom data here
                .and()
                .subject(Username) // The "Subject" is the person the token belongs to
                .issuedAt(new Date(System.currentTimeMillis())) // The time the token was created
                // The time the token will stop working (30 minutes from now)
                .expiration(new Date(System.currentTimeMillis() + 1000 * 60 * 30)) 
                .signWith(getKey()) // Sign the token using our unique Secret Key
                .compact(); // Finalize and convert to a String
    }

    /**
     * This helper method decodes our Base64 secret key and prepares it for the library to use.
     */
    private Key getKey() {
        byte[] keyBytes = Decoders.BASE64.decode(secretekey);
        return Keys.hmacShaKeyFor(keyBytes);
    }

    public String extractUsername(String token) {
        return extractClaim(token, Claims::getSubject);
    }

    private <T> T extractClaim(String token, Function<Claims, T> claimResolver) {
        final Claims claims = extractAllClaims(token);
        return claimResolver.apply(claims);
    }

    private Claims extractAllClaims(String token) {
        return Jwts.parser()
                .verifyWith((SecretKey) getKey())
                .build()
                .parseSignedClaims(token)
                .getPayload();
    }

    public boolean validateToken(String token, UserDetails userDetails) {
        final String username = extractUsername(token);
        return (username.equals(userDetails.getUsername()) && !isTokenExpired(token));
    }

    private boolean isTokenExpired(String token) {
        return extractExpiration(token).before(new Date());
    }

    private Date extractExpiration(String token) {
        return extractClaim(token, Claims::getExpiration);
    }
}
