package com.amigos.notification;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/api/v1/notification")
@AllArgsConstructor
public class NotificationController {

    private final NotificationService notificationService;

    @PostMapping("/{customerId}/{email}")
    public void sendNotification(@PathVariable("customerId") Integer customerId, @PathVariable("email") String email){

      log.info("INSIDE NOTIFICATION CONTROLLER");
        notificationService.sendAndSaveNotification(customerId, email);

    }
}
