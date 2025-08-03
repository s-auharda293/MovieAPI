package com.movieflix.movieApi.auth.service;

import com.movieflix.movieApi.auth.entities.RefreshToken;
import com.movieflix.movieApi.auth.entities.User;
import com.movieflix.movieApi.auth.repositories.RefreshTokenRepository;
import com.movieflix.movieApi.auth.repositories.UserRepository;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.sql.Ref;
import java.time.Instant;
import java.util.UUID;

@Service
public class RefreshTokenService {

    private final UserRepository userRepository;

    private final RefreshTokenRepository refreshTokenRepository;

    public RefreshTokenService(UserRepository userRepository, RefreshTokenRepository refreshTokenRepository){
        this.userRepository = userRepository;
        this.refreshTokenRepository = refreshTokenRepository;
    }

    public RefreshToken createRefreshToken(String username){
        User user = userRepository.findByUsername(username)
                .orElseThrow(()-> new UsernameNotFoundException("User not found with email: " + username));
        RefreshToken refreshToken = user.getRefreshToken();

        if(refreshToken == null){
            long refreshTokenValidity = 5*60*60*1000;
            refreshToken = RefreshToken.builder()
                    .refreshToken(UUID.randomUUID().toString())
                    .expirationTime(Instant.now().plusMillis(refreshTokenValidity))
                    .user(user)
                    .build();

            refreshTokenRepository.save(refreshToken);
        }
        return refreshToken;
    }

    public RefreshToken verifyRefreshToken(String refreshToken){
        RefreshToken refToken = refreshTokenRepository .findByRefreshToken(refreshToken)
                .orElseThrow(()->new RuntimeException("Refresh token not found!"));
        if(refToken.getExpirationTime().compareTo(Instant.now())<0){
            refreshTokenRepository.delete(refToken);
            throw new RuntimeException("Refresh Token expired");
        }
        return refToken;
    }
}
