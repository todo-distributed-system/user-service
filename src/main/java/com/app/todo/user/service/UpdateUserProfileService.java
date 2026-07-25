package com.app.todo.user.service;

import com.app.todo.user.entity.UserProfile;
import com.app.todo.user.repository.UserProfileRepository;
import com.app.todo.user.request.UserProfileUpdateRequest;
import com.app.todo.user.response.UserProfileDto;
import com.app.todo.user.utility.CurrentUser;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UpdateUserProfileService {

    private final UserProfileRepository userProfileRepository;
    private final CurrentUser currentUser;

    public UserProfileDto updateUserProfile(UserProfileUpdateRequest userProfileUpdateRequest) {
        UserProfile userProfile = userProfileRepository.findById(currentUser.getUserId()).orElseThrow();


        userProfile.setFirstName(userProfileUpdateRequest.getFirstName());
        userProfile.setLastName(userProfileUpdateRequest.getLastName());
        userProfile.setDateOfBirth(userProfileUpdateRequest.getDateOfBirth());
        userProfile.setPhone(userProfileUpdateRequest.getPhone());

        userProfile = userProfileRepository.save(userProfile);

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
