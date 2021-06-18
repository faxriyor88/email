package com.example.email.repository;


import com.example.email.custom.WarehouseCustom;
import com.example.email.entity.Warehouse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path = "warehouse",excerptProjection = WarehouseCustom.class)
public interface WarehouseRepository extends JpaRepository<Warehouse,Integer> {
}
