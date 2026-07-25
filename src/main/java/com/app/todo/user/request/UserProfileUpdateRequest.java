package com.app.todo.user.request;

import lombok.Data;

import java.time.LocalDate;

@Data
public class UserProfileUpdateRequest {
    private String firstName;
    private String lastName;
    private LocalDate dateOfBirth;
    private String phone;
}
