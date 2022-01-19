package com.amigoscode.customer;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.transaction.Transactional;

@Slf4j
@Service
@AllArgsConstructor
@Transactional
public class CustomerService {

    private final CustomerRepo customerRepo;
    private final RestTemplate restTemplate;

    public void registerCustomer(CustomerRegistrationRequest customerRegistrationRequest) {

        var customer = Customer.builder()
                .firstName(customerRegistrationRequest.getFirstName())
                .lastName(customerRegistrationRequest.getLastName())
                .email(customerRegistrationRequest.getEmail())
                .build();

        // TODO: 1/18/2022 check if email is valid
        // TODO: 1/18/2022 check if email is not taken

        customerRepo.saveAndFlush(customer);

        var fraudCheckResponse = restTemplate.getForObject(
                "http://localhost:8081/api/v1/fraud-check/{customerId}", FraudCheckResponse.class, customer.getId());

        if(fraudCheckResponse.getIsFraudster()){
            log.error("error thrown");
            throw new IllegalStateException("fraudster");
        }

        // TODO: 1/18/2022 send notification 
        log.info("user saved");
    }
}
