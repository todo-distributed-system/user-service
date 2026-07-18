package com.app.todo.user.controller;

import com.app.todo.user.request.CreateUserRequest;
import com.app.todo.user.response.CreateUserResponse;
import com.app.todo.user.service.CreateUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/app/todo/user")
@RequiredArgsConstructor
public class UserController {

    private final CreateUserService createUserService;

    @PostMapping("/create")
    public ResponseEntity<CreateUserResponse> createUserProfile(@RequestBody CreateUserRequest createUserRequest) {
        return ResponseEntity.ok(createUserService.createUser(createUserRequest));
    }

    @GetMapping("/greet")
    public Map<String, String> greet() {
        return Map.of("message", "working on docker");
    }

}
