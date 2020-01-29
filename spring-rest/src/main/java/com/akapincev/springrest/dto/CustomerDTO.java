package com.akapincev.springrest.dto;

import lombok.Data;

import javax.validation.constraints.Pattern;

@Data
public class CustomerDTO {

    private String firstName;

    @Pattern(regexp = "^([a-zA-Z0-9_-]{1,64})", message = "Lastname must be max. 64, alphanumeric, dash or underscore")
    private String lastName;

    private String salutation;
}
