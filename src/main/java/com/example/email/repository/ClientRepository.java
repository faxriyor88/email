package com.example.email.repository;


import com.example.email.custom.ClientCustom;
import com.example.email.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path = "client",excerptProjection = ClientCustom.class)
public interface ClientRepository extends JpaRepository<Client,Integer> {
}
