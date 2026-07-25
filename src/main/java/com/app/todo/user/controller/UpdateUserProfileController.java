package com.app.todo.user.controller;

import com.app.todo.user.request.UserProfileUpdateRequest;
import com.app.todo.user.response.UserProfileDto;
import com.app.todo.user.service.UpdateUserProfileService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/app/todo/user")
public class UpdateUserProfileController {

    private final UpdateUserProfileService userProfileService;

    @PatchMapping("/profile/update")
    public ResponseEntity<UserProfileDto> updateUserProfile(@RequestBody UserProfileUpdateRequest userProfileUpdateRequest) {
        return ResponseEntity.ok(userProfileService.updateUserProfile(userProfileUpdateRequest));
    }

}
