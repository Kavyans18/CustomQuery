package com.pw.custom_query.dto;

import lombok.Data;

@Data
public class UserDto {

    private int id;
    private String firstName;
    private String lastName;
    private String gender;
    private String email;
    private long phoneNumber;
}
