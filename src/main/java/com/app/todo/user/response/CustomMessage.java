package com.app.todo.user.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CustomMessage {
    private String message;
}
