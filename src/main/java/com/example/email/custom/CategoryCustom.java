package com.example.email.custom;


import com.example.email.entity.Category;
import org.springframework.data.rest.core.config.Projection;

@Projection(types = Category.class)
public interface CategoryCustom {
    Integer getId();
    String getName();
    Category getParent_category_id();
    boolean getActive();
}
