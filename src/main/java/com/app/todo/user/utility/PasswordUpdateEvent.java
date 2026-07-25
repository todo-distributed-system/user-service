package com.app.todo.user.utility;

import lombok.Builder;
import lombok.Data;

import java.util.UUID;

@Data
@Builder
public class PasswordUpdateEvent {
    private UUID userId;
    private String updatedPassword;
}
