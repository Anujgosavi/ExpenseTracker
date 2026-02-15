package org.example.Service;

import org.example.Entity.RefreshToken;
import org.example.Entity.UserInfo;
import org.example.Repository.RefreshTokenRepository;
import org.example.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.Instant;
import java.util.UUID;

public class RefreshTokenService {

    @Autowired
    RefreshTokenRepository refreshTokenRepository;


    @Autowired
    UserRepository userRepository;


    public RefreshToken createRefreshToken(String username) {
        UserInfo userInfoExtracted = userRepository.findByUserName(username);
        RefreshToken refreshToken = RefreshToken.builder()
                .userInfo(userInfoExtracted)
                .token(UUID.randomUUID().toString())
                .expiryDate(Instant.now().plusMillis(600000))
                .build();


        return refreshTokenRepository.save(refreshToken);
    }


    public RefreshToken verifyExpiration(RefreshToken token) {
        if (token.getExpiryDate().compareTo(Instant.now()) < 0) {
            refreshTokenRepository.delete(token);
            throw new RuntimeException(token.getToken() + " Refresh token is expired. Please make a new login token ");
        }

        return token;
    }

}