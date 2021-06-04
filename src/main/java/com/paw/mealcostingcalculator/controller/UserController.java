package com.paw.mealcostingcalculator.controller;

import com.paw.mealcostingcalculator.configuration.SpringFoxConfig;
import com.paw.mealcostingcalculator.dtos.JWTokenDTO;
import com.paw.mealcostingcalculator.dtos.UserDTO;
import com.paw.mealcostingcalculator.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@Api(tags = {SpringFoxConfig.user})
public class UserController {

    private final UserService userService;

    @ApiOperation(value = "Logs user into the system")
    @PostMapping(value = "/login")
    private JWTokenDTO login(@Valid @RequestBody UserDTO userDTO) {
        return userService.authenticateAndGetToken(userDTO);
    }

    @ApiOperation(value = "Logs out user current logged in user session")
    @PostMapping(value = "/logout")
    public void logout() {
    }

    @ApiOperation(value = "Creates a new user")
    @PostMapping(value = "/signup")
    public void signup(@Valid @RequestBody UserDTO userDTO) {
        userService.addUser(userDTO);
    }
}
