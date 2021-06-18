package com.example.email.repository;

import com.example.email.custom.CategoryCustom;
import com.example.email.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path = "category",excerptProjection = CategoryCustom.class)
public interface CategoryRepository extends JpaRepository<Category,Integer> {
}
