package com.example.email.custom;


import com.example.email.entity.OutPut;
import com.example.email.entity.OutPutProduct;
import com.example.email.entity.Product;
import org.springframework.data.rest.core.config.Projection;

import java.util.UUID;

@Projection(types = OutPutProduct.class)
public interface OutPutProductCustom {
    Integer getId();
    Product getProduct_id();
    String getAmount();
    String getPrice();
    OutPut getOutPut();
    UUID getCreatedBy();
    UUID getUpdatedBy();
}
