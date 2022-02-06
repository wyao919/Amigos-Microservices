package com.amigoscode.clients.notification;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient(name = "NOTIFICATION", path = "/api/v1/notification")
public interface NotificationClient {

    @PostMapping("/{customerId}/{email}")
    NotificationRequest sendAndSaveNotification(@PathVariable("customerId") Integer customerId, @PathVariable("email") String email);

}
