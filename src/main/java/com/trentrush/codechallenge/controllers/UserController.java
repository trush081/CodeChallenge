package com.trentrush.codechallenge.controllers;

import com.trentrush.codechallenge.DTOs.CountDTO;
import com.trentrush.codechallenge.entities.User;
import com.trentrush.codechallenge.services.UserService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controller class for users
 * <p>
 * Author: Trenton Rush (trush081@gmail.com)
 * Circa: 10/14/2022
 */
@RestController
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @Operation(summary = "Add a new user")
    @PostMapping(path = "/user", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CountDTO> saveUser(@RequestBody User user) {
        return ResponseEntity.ok(userService.addUser(user));
    }
}
