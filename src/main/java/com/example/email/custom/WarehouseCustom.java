package com.example.email.custom;


import com.example.email.entity.Warehouse;
import org.springframework.data.rest.core.config.Projection;

@Projection(types = Warehouse.class)
public interface WarehouseCustom {
    Integer getId();
    String getName();
    boolean getActive();
}
