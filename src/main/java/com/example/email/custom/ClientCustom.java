package com.example.email.custom;


import com.example.email.entity.Client;
import org.springframework.data.rest.core.config.Projection;

@Projection(types = Client.class)
public interface ClientCustom {
    Integer getId();
    String getName();
    String getPhone_number();
}
