package com.app.todo.user.request;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
public class CreateUserRequest {

    private UUID userId;
    private String email;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

}
