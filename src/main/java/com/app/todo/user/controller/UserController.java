package com.app.todo.user.controller;

import com.app.todo.user.request.CreateUserRequest;
import com.app.todo.user.response.CreateUserResponse;
import com.app.todo.user.service.CreateUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/app/todo/user")
@RequiredArgsConstructor
public class UserController {

    private final CreateUserService createUserService;

    @PostMapping("/create")
    public ResponseEntity<CreateUserResponse> createUserProfile(@RequestBody CreateUserRequest createUserRequest) {
        return ResponseEntity.ok(createUserService.createUser(createUserRequest));
    }

}
