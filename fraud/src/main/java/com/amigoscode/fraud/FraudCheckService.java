package com.amigoscode.fraud;

import com.amigoscode.clients.notification.NotificationClient;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Slf4j
@Service
@Transactional
@AllArgsConstructor
public class FraudCheckService {

    private final FraudCheckHistoryRepo fraudCheckHistoryRepo;

    public boolean isFraudulentCustomer(Integer customerId, String email){

        System.out.println("inside fraud service");
        fraudCheckHistoryRepo.save(
                FraudCheckHistory.builder()
                        .isFraudster(false)
                        .customerId(customerId)
                        .build()
        );
        System.out.println("inside fraud service2");


        System.out.println(email);

        return false;
    }
}
