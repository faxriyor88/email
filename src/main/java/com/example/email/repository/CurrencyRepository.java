package com.example.email.repository;

import com.example.email.custom.CurrencyCustom;
import com.example.email.entity.Currency;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path = "currency",excerptProjection = CurrencyCustom.class)
public  interface CurrencyRepository extends JpaRepository<Currency,Integer> {
}
