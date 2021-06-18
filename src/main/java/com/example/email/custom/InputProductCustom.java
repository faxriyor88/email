package com.example.email.custom;


import com.example.email.entity.Input;
import com.example.email.entity.InputProduct;
import com.example.email.entity.Product;
import org.springframework.data.rest.core.config.Projection;

import java.time.LocalDate;
import java.util.UUID;

@Projection(types = InputProduct.class)
public interface InputProductCustom {
    Integer getId();

    Product getProduct_id();

    String getAmount();

    String getPrice();

    LocalDate getExpire_date();

    Input getInput();

    UUID getCreatedBy();

    UUID getUpdatedBy();
}