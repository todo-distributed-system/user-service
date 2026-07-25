package com.app.todo.user.controller;

import com.app.todo.user.request.PasswordUpdateRequest;
import com.app.todo.user.response.CustomMessage;
import com.app.todo.user.service.UpdatePasswordService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/app/todo/user")
public class UpdatePasswordController {

    private final UpdatePasswordService updatePasswordService;

    @PatchMapping("/profile/password/update")
    public ResponseEntity<CustomMessage> updatePassword(@RequestBody PasswordUpdateRequest passwordUpdateRequest) {
        return ResponseEntity.ok(updatePasswordService.updateUserProfilePassword(passwordUpdateRequest));
    }
}
