package com.amigoscode.customer;

import com.amigoscode.clients.fraud.FraudCheckResponse;
import com.amigoscode.clients.fraud.FraudClient;
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
    private final FraudClient fraudClient;

    public void registerCustomer(CustomerRegistrationRequest customerRegistrationRequest) {

        var customer = Customer.builder()
                .firstName(customerRegistrationRequest.getFirstName())
                .lastName(customerRegistrationRequest.getLastName())
                .email(customerRegistrationRequest.getEmail())
                .build();

        // TODO: 1/18/2022 check if email is valid
        // TODO: 1/18/2022 check if email is not taken

        customerRepo.saveAndFlush(customer);

        FraudCheckResponse fraudster = fraudClient.isFraudster(customer.getId());

        if(fraudster.getIsFraudster()){
            log.error("err  or thrown");
            throw new IllegalStateException("fraudster");
        }

        // TODO: 1/18/2022 send notification 
        log.info("user saved");
    }
}
