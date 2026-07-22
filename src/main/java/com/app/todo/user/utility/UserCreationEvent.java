package com.app.todo.user.utility;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserCreationEvent {
    private UUID userId;
    private String email;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
