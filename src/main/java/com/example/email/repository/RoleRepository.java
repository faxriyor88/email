package com.example.email.repository;

import com.example.email.entity.Role;
import com.example.email.entity.enums.Rolename;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role,Integer> {
Role findByRolename(Rolename rolename);

}