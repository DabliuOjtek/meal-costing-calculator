package com.paw.mealcostingcalculator.controller;

import com.paw.mealcostingcalculator.configuration.SpringFoxConfig;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@Api(tags={SpringFoxConfig.user})
public class UserController {

    @ApiOperation(value = "Logs user into the system")
    @PostMapping("/user/login")
    private void userLogin(){

    }

    @ApiOperation(value = "Logs out user current logged in user session")
    @PostMapping("/user/logout")
    private void userLogout(){

    }

    @ApiOperation(value = "Creates a new user")
    @PostMapping("/user/register")
    private void userRegister(){

    }

    @ApiOperation(value = "Changes current logged user's password")
    @PutMapping("/user/changePassword")
    private void userChangePassword(){

    }
}
