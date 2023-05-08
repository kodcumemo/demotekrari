package com.tekrar.demotekrari.model;

import lombok.Data;

@Data
public class User {

    private Integer id;
    private String email;
    private String password;
    private Double balance;
    private int roll;

}
