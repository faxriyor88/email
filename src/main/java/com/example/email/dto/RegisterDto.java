package com.example.email.dto;

import lombok.Data;


import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
public class RegisterDto {
    @Size(min = 4,max = 50)
    private String firstname;
    @Size(min = 4,max = 50)
    private String lastname;
    @NotNull
    @Email
    private String email;
    @NotNull
    private String password;
}
