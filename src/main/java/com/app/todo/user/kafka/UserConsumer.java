package com.app.todo.user.kafka;

import com.app.todo.user.entity.UserProfile;
import com.app.todo.user.repository.UserProfileRepository;
import com.app.todo.user.utility.UserCreationEvent;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UserConsumer {

    private final UserProfileRepository userProfileRepository;

    @KafkaListener(
            topics = "user-create-events",
            groupId = "user-group")
    public void consume(UserCreationEvent userEvent) {

        System.out.println("+++++++++++ " + userEvent);

        UserProfile userProfile = UserProfile.builder()
                .userId(userEvent.getUserId())
                .email(userEvent.getEmail())
                .createdAt(userEvent.getCreatedAt())
                .updatedAt(userEvent.getUpdatedAt())
                .build();

        userProfileRepository.save(userProfile);
    }

}
