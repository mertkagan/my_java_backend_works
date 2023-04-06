package com.mertkagan.hobbyto.business.requests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Data
public class CreateUsersRequest {

    private  Long id;

    private String name;
    private String surName;
    private String userName;
    private String email;
    private String password;





}
