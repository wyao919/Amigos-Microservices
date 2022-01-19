package com.amigoscode.customer;

import lombok.Data;
import lombok.ToString;

@Data
public class CustomerRegistrationRequest {

         private String firstName;
         private String lastName;
         private String email;
}
