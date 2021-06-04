package com.paw.mealcostingcalculator.mapper;

import com.paw.mealcostingcalculator.model.RoleEntity;
import com.paw.mealcostingcalculator.model.UserEntity;

import java.util.Set;

public class UserMapper {
    public static UserEntity mapToUser(String username, String password, Set<RoleEntity> roles) {
        UserEntity userEntity = new UserEntity();
        userEntity.setUsername(username);
        userEntity.setPassword(password);
        userEntity.setRoles(roles);
        return userEntity;
    }
}
