package com.example.email.custom;

import com.example.email.entity.Currency;
import com.example.email.entity.Input;
import com.example.email.entity.Supplier;
import com.example.email.entity.Warehouse;
import org.springframework.data.rest.core.config.Projection;

import java.time.LocalDate;

@Projection(types = Input.class)
public interface InputCustom {
    Integer getId();
    LocalDate getDate();
    Warehouse getWarehouse();
    Supplier getSupplier();
    Currency getCurrency();
    String getFacture_number();
    Integer getCode();

}
