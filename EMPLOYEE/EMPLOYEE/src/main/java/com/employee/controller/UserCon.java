package com.employee.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.employee.model.dto.CreateUserRequest;
import com.employee.service.UserService;

@RestController
@RequestMapping("/api/users")

public class UserCon {

    private final UserService userService;

    public UserCon(UserService userService) {
		super();
		this.userService = userService;
	}

	@PostMapping
    public ResponseEntity<String> createUser(
            @RequestBody CreateUserRequest request) {

        userService.createUser(request);

        return ResponseEntity.ok("User created successfully. Email sent.");
    }
}
