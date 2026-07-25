package com.app.todo.user.service;

import com.app.todo.user.request.PasswordUpdateRequest;
import com.app.todo.user.response.CustomMessage;
import com.app.todo.user.utility.CurrentUser;
import com.app.todo.user.utility.PasswordUpdateEvent;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UpdatePasswordService {

    private final CurrentUser currentUser;
    private final KafkaTemplate<String, PasswordUpdateEvent> kafkaTemplate;

    public CustomMessage updateUserProfilePassword(PasswordUpdateRequest passwordUpdateRequest) {

        PasswordUpdateEvent passwordUpdateEvent = PasswordUpdateEvent.builder()
                .userId(currentUser.getUserId())
                .updatedPassword(passwordUpdateRequest.getUpdatedPassword())
                .build();

        kafkaTemplate.send("password-update-event", passwordUpdateEvent);

        return CustomMessage.builder()
                .message("Updated Password Successfully")
                .build();
    }

}
