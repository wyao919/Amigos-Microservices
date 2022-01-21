package com.amigoscode.customer;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;

@Slf4j
@RestController
@RequestMapping("/api/v1")
public record CustomerController (CustomerService customerService){

    @PostConstruct
    void check(){
        System.out.println("working");
    }

    @PostMapping("/customer")
    public void registerCustomer(@RequestBody CustomerRegistrationRequest customerRegistrationRequest){
        log.info("new customer registration {}", customerRegistrationRequest );
        customerService.registerCustomer(customerRegistrationRequest);
    }

}
