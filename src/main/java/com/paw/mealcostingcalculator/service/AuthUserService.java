package com.paw.mealcostingcalculator.service;

import com.paw.mealcostingcalculator.configuration.security.JWTUtils;
import com.paw.mealcostingcalculator.model.TokenBlockListEntity;
import com.paw.mealcostingcalculator.model.UserEntity;
import com.paw.mealcostingcalculator.repository.TokenBlockListRepository;
import com.paw.mealcostingcalculator.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
public class AuthUserService implements UserDetailsService {

    private final UserRepository userRepository;
    private final TokenBlockListRepository tokenBlockListRepository;
    private final JWTUtils jwtUtils;

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        UserEntity user = userRepository.findByUsername(s)
                .orElseThrow(()->new UsernameNotFoundException("User not found"));
        return UserDetailsImpl.build(user);
    }

    public void addTokenToBlockList(String authToken){
        if (authToken == null)
            return;
        authToken = authToken.replace("Bearer ","");
        TokenBlockListEntity blockToken = new TokenBlockListEntity();
        blockToken.setToken(authToken);
        blockToken.setExpiredAt(jwtUtils.getExpiredTimeFromToken(authToken));

        tokenBlockListRepository.save(blockToken);
    }

    public void logoutUser(String token){
        addTokenToBlockList(token);
        SecurityContextHolder.clearContext();
    }
}
