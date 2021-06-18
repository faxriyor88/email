package com.example.email.repository;

import com.example.email.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface UserRepository extends JpaRepository<User, UUID> {
  boolean existsByEmail(String email);
  Optional<User> findByEmailAndEmailCode(String email,String emailCode);
  Optional<User> findByEmailAndPassword(String email, String password);

  Optional<User> findByEmail(String email);
}
