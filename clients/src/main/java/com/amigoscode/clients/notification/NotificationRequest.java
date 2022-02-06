package com.amigoscode.clients.notification;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class NotificationRequest {

    private int id;
    private Boolean isNotified;
    private String customerEmail;
    private String sender;
    private String message;
}
