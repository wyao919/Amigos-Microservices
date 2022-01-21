package com.amigos.notification;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Slf4j
@Service
@AllArgsConstructor
@Transactional
public class NotificationService {

    private final NotificationRepo notificationRepo;

    public void sendAndSaveNotification(Integer customerId, String customerEmail){

        Notification notification = Notification.builder()
                .isNotified(true)
                .customerId(customerId)
                .sender("amigos code")
                .customerEmail(customerEmail)
                .message("Welcome to amigos")
                .build();

        notificationRepo.save(notification);
        log.info("Notification Saved for customer {}", customerId);
    }

}
