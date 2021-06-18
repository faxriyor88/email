package com.example.email.repository;

import com.example.email.custom.SupplierCustom;
import com.example.email.entity.Supplier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path = "supplier",excerptProjection = SupplierCustom.class)
public interface SupplierRepository extends JpaRepository<Supplier,Integer> {
}
