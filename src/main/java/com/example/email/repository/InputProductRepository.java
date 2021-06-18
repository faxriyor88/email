package com.example.email.repository;


import com.example.email.custom.InputProductCustom;
import com.example.email.entity.InputProduct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;


@RepositoryRestResource(path = "inputproduct",excerptProjection = InputProductCustom.class)
public interface InputProductRepository extends JpaRepository<InputProduct,Integer> {
}
