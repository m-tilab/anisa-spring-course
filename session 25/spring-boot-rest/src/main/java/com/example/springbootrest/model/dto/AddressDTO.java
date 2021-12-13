package com.example.springbootrest.model.dto;

import lombok.Data;

@Data
public class AddressDTO {

    private String id;
    private String city;
    private String country;
    private String streetName;
    private String postalCode;
    private String type;
    private UserDTO userDTO;

}
