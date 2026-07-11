package com.app.todo.user.service;

import com.app.todo.user.entity.UserProfile;
import com.app.todo.user.repository.UserProfileRepository;
import com.app.todo.user.request.CreateUserRequest;
import com.app.todo.user.response.CreateUserResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CreateUserService {

    private final UserProfileRepository userProfileRepository;

    public CreateUserResponse createUser(CreateUserRequest createUserRequest) {

        UserProfile userProfile = UserProfile.builder()
                .userId(createUserRequest.getUserId())
                .email(createUserRequest.getEmail())
                .createdAt(createUserRequest.getCreatedAt())
                .updatedAt(createUserRequest.getUpdatedAt())
                .build();

        userProfileRepository.save(userProfile);

        return CreateUserResponse.builder()
                .message("User Profile Created Successfully")
                .build();
    }
}
