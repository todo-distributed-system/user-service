package com.app.todo.user.service;

import com.app.todo.user.entity.UserProfile;
import com.app.todo.user.repository.UserProfileRepository;
import com.app.todo.user.response.UserProfileDto;
import com.app.todo.user.utility.CurrentUser;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class GetUserProfileService {

    private final CurrentUser currentUser;
    private final UserProfileRepository userProfileRepository;

    public UserProfileDto getUserProfile() {

        UUID userId = currentUser.getUserId();

        UserProfile userProfile = userProfileRepository.findById(userId).orElseThrow(() -> new RuntimeException());

        return UserProfileDto.builder()
                .email(userProfile.getEmail())
                .firstName(userProfile.getFirstName())
                .lastName(userProfile.getLastName())
                .dateOfBirth(userProfile.getDateOfBirth())
                .phone(userProfile.getPhone())
                .createdAt(userProfile.getCreatedAt())
                .updatedAt(userProfile.getUpdatedAt())
                .build();
    }

}
