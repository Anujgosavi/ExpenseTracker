package org.example.Service;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.example.Entity.RefreshToken;
import org.example.Entity.UserInfo;
import org.example.Repository.RefreshTokenRepository;
import org.example.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.UUID;


@Service
@AllArgsConstructor
@Data
public class UserDetailServiceImp implements UserDetailsService {


    @Autowired
    private final UserRepository userRepository;

    @Autowired
    private final PasswordEncoder passwordEncoder;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserInfo   user = userRepository.findByUserName(username);
        if(user == null) {
            throw new UsernameNotFoundException("could not found user ..!! ");
        }

            return new CustomUserDetails(user);
    }
}