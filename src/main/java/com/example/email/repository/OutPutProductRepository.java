package com.example.email.repository;



import com.example.email.custom.OutPutProductCustom;
import com.example.email.entity.OutPutProduct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path = "outputproduct",excerptProjection = OutPutProductCustom.class)
public interface OutPutProductRepository extends JpaRepository<OutPutProduct,Integer> {
}
