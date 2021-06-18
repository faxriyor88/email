package com.example.email.custom;



import com.example.email.entity.Supplier;
import org.springframework.data.rest.core.config.Projection;


@Projection(types = Supplier.class)
public interface SupplierCustom {
    Integer getId();
    String getName();
    boolean getActive();
    String getPhone_number();
}
