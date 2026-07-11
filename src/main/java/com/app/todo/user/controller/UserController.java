package com.app.todo.user.controller;

import lombok.Builder;
import lombok.Data;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/app/todo/user")
public class UserController {

    @Data
    @Builder
    private static class Message {
        private String message;
    }

    @GetMapping("/greeting")
    public Message greet() {
        return Message.builder()
                .message("Hii, hello, welcome")
                .build();
    }

}
