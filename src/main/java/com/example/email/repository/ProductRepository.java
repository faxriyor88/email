package com.example.email.repository;


import com.example.email.custom.ProductCustom;
import com.example.email.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path = "product",excerptProjection = ProductCustom.class)
public interface ProductRepository extends JpaRepository<Product,Integer> {
}
