package com.example.email.custom;


import com.example.email.entity.Attachment;
import com.example.email.entity.Category;
import com.example.email.entity.Measurement;
import com.example.email.entity.Product;
import org.springframework.data.rest.core.config.Projection;

@Projection(types = Product.class)
public interface ProductCustom {
    Integer getId();
    String getName();
    Category getCategory();
    Attachment getPhoto_id();
    String getCode();
    Measurement getMeasurement();
    boolean getActive();
}
