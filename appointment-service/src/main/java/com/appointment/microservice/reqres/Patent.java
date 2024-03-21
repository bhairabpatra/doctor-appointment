package com.appointment.microservice.reqres;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Patent {
    private Long id;
    private String firstName;
    private String email;
    private String gender;
    private String phone;

}
