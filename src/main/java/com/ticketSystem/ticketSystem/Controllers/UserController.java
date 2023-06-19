package com.ticketSystem.ticketSystem.Controllers;

import com.ticketSystem.ticketSystem.Models.APICustomResponse;
import com.ticketSystem.ticketSystem.Models.User;
import com.ticketSystem.ticketSystem.Services.UserService;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

import static org.springframework.http.HttpStatus.CREATED;

@RestController
@RequestMapping("api/register")
public class UserController extends GenericController {
    @Autowired
    UserService userService;

    @PostMapping
    public ResponseEntity<APICustomResponse> createUser(
            @NonNull
            @RequestBody User user) {
        Long userId = userService.createUser(user);
        return createResponse(
                Map.of("userId", userId),
                "User created successfully",
                CREATED);
    }
}
