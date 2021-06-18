package com.example.email.repository;

import com.example.email.custom.InputCustom;
import com.example.email.entity.Input;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;


@RepositoryRestResource(path = "input",excerptProjection = InputCustom.class)
public interface InputRepository extends JpaRepository<Input,Integer> {
}
