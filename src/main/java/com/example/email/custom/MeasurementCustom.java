package com.example.email.custom;


import com.example.email.entity.Measurement;
import org.springframework.data.rest.core.config.Projection;

@Projection(types = Measurement.class)
public interface MeasurementCustom {
    Integer getId();
    String getName();
    boolean getActive();
}
