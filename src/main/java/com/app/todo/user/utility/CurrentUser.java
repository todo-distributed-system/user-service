package com.app.todo.user.utility;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class CurrentUser {

    public UUID getUserId() {
        return (UUID) SecurityContextHolder
                .getContext()
                .getAuthentication()
                .getPrincipal();
    }

}
