package com.example.email.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Collection;

import java.util.Set;
import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "foydalanuvchi")
public class User implements UserDetails {
   @Id
   @GeneratedValue
   private UUID id;
   private String firstname;
   private String lastname;
   @Column(nullable = false,unique = true)
   private String email;
   @Column(nullable = false)
   private String password;
   @Column(nullable = false,updatable = false)
   @CreationTimestamp
   private Timestamp createdAt;
   @UpdateTimestamp
   private Timestamp updateAt;

   @ManyToMany
   private Set<Role> roles;

   private String emailCode;

   private boolean accountNonExpired=true;
   private boolean accountNonLocked=true;
   private boolean credentialsNonExpired=true;
   private boolean enabled;


   @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return this.roles;
    }



    @Override
    public String getUsername() {
        return this.email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return this.accountNonExpired;
    }

    @Override
    public boolean isAccountNonLocked() {
        return this.accountNonLocked;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return this.credentialsNonExpired;
    }

    @Override
    public boolean isEnabled() {
        return this.enabled;
    }

    public User(String firstname, String lastname, String email, String password, Set<Role> roles,String emailCode) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.password = password;
        this.roles = roles;
        this.emailCode=emailCode;
    }
}
