package com.amigoscode.clients.fraud;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient(name = "FRAUD", path = "api/v1/fraud-check")
public interface FraudClient {

   @PostMapping("/{customerId}/{email}")
   FraudCheckResponse isFraudster(@PathVariable("customerId") Integer customerId, @PathVariable("email") String email);

}
