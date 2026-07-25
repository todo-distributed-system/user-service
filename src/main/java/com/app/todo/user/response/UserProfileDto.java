package com.app.todo.user.response;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Builder
@Data
public class UserProfileDto {
    private String email;
    private String firstName;
    private String lastName;
    private LocalDate dateOfBirth;
    private String phone;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
