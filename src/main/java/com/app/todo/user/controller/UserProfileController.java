package com.app.todo.user.controller;

import com.app.todo.user.response.UserProfileDto;
import com.app.todo.user.service.GetUserProfileService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/app/todo/user")
@RequiredArgsConstructor
public class UserProfileController {

    private final GetUserProfileService getUserProfileService;

    @GetMapping("/profile")
    public ResponseEntity<UserProfileDto> getUserProfile() {
        return ResponseEntity.ok(getUserProfileService.getUserProfile());
    }
}
