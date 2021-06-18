package com.example.email.repository;


import com.example.email.custom.OutPutCustom;
import com.example.email.entity.OutPut;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path = "output",excerptProjection = OutPutCustom.class)
public interface OutPutRepository extends JpaRepository<OutPut,Integer> {
}
