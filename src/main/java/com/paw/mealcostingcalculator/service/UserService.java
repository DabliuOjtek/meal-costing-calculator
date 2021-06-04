package com.paw.mealcostingcalculator.service;

import com.paw.mealcostingcalculator.configuration.security.JWTUtils;
import com.paw.mealcostingcalculator.dtos.JWTokenDTO;
import com.paw.mealcostingcalculator.dtos.UserDTO;
import com.paw.mealcostingcalculator.mapper.UserMapper;
import com.paw.mealcostingcalculator.model.RoleEntity;
import com.paw.mealcostingcalculator.model.UserEntity;
import com.paw.mealcostingcalculator.repository.RoleRepository;
import com.paw.mealcostingcalculator.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.HashSet;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;
    private final JWTUtils jwtUtils;

    public JWTokenDTO authenticateAndGetToken(UserDTO userDTO) {
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                userDTO.getUsername(), userDTO.getPassword())
        );

        return new JWTokenDTO(jwtUtils.generateToken(authentication));
    }

    @Transactional
    public void addUser(UserDTO userDTO) {
        if (userRepository.existsByUsername(userDTO.getUsername()))
            throw new RuntimeException("User already exist");

        Set<RoleEntity> roleSet = new HashSet<>();
        roleSet.add(
                roleRepository.findByName(RoleEntity.ERole.USER)
                        .orElseThrow()
        );

        UserEntity user = UserMapper.mapToUser(
                userDTO.getUsername(),
                passwordEncoder.encode(userDTO.getPassword()),
                roleSet
        );

        userRepository.save(user);
    }

    public UserEntity getUserByUsername(String username) {
        return userRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));
    }
}
