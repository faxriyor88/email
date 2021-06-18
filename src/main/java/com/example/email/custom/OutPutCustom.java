package com.example.email.custom;



import com.example.email.entity.Client;
import com.example.email.entity.Currency;
import com.example.email.entity.OutPut;
import com.example.email.entity.Warehouse;
import org.springframework.data.rest.core.config.Projection;

import java.time.LocalDate;

@Projection(types = OutPut.class)
public interface OutPutCustom {
    Integer getId();

    LocalDate getDate();

    Warehouse getWarehouse();

    Currency getCurrency();

    String getFacture_number();

    String getCode();

    Client getClient();
}
