package com.example.email.repository;


import com.example.email.custom.MeasurementCustom;

import com.example.email.entity.Measurement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path = "measurment",excerptProjection = MeasurementCustom.class)
public interface MeasurmentRepository extends JpaRepository<Measurement,Integer> {
}
