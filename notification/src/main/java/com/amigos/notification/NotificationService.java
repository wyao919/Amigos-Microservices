package com.amigos.notification;

import com.amigoscode.clients.notification.NotificationRequest;
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

    public void sendAndSaveNotification(NotificationRequest notificationRequest){

        Notification notification = Notification.builder()
                .isNotified(true)
                .customerId(notificationRequest.getId())
                .sender(notificationRequest.getSender())
                .customerEmail(notificationRequest.getCustomerEmail())
                .message(notificationRequest.getMessage())
                .build();

        notificationRepo.save(notification);
        log.info("Notification Saved for customer {}", notification.getCustomerId());
    }

}
