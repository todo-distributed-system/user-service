package com.app.todo.user.controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/app/todo/user")
public class UserProfileController {

    @GetMapping("/profile")
    public String getUserId() {
        Authentication authentication =
                SecurityContextHolder.getContext().getAuthentication();

        return authentication.getPrincipal().toString();
    }

}
