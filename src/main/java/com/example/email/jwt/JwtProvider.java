package com.example.email.jwt;

import com.example.email.entity.Role;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Component;
import io.jsonwebtoken.Jwts;

import java.util.Date;
import java.util.Set;

@Component
public class JwtProvider {
    private String secret="kalitsoz";
    private long expireTime=36_000_000;
    public String generateToken(String email, Set<Role> roles){
        String token = Jwts
                .builder()
                .setSubject(email)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + expireTime))
                .claim("roles", roles)
                .signWith(SignatureAlgorithm.HS256, secret)
                .compact();
        return token;
    }
    public String getEmailFromToken(String token){
        try
        {String subject = Jwts
                .parser()
                .setSigningKey(secret)
                .parseClaimsJws(token)
                .getBody()
                .getSubject();
        return subject;
        }catch (Exception e){
            return null;
        }
    }
}
