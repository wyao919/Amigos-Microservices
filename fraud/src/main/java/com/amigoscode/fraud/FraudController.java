package com.amigoscode.fraud;

import com.amigoscode.clients.fraud.FraudCheckResponse;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/fraud-check")
public class FraudController {

    private final FraudCheckService fraudCheckService;

    @PostMapping("/{customerId}/{email}")
    public FraudCheckResponse isFraudster(@PathVariable("customerId") Integer customerId, @PathVariable("email") String email){

        log.info("INSIDE FRAUD CONTROLLER");
        boolean isFraudulentCustomer = fraudCheckService.isFraudulentCustomer(customerId, email);

        log.info("FRAUD CONTROLLER - fraud check request for customer {}", customerId);

        return new FraudCheckResponse(isFraudulentCustomer);
    }
}
