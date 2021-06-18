package com.example.email.custom;


import com.example.email.entity.Role;
import com.example.email.entity.User;
import org.springframework.data.rest.core.config.Projection;

import java.sql.Timestamp;
import java.util.Set;

@Projection(types = User.class)
public interface UserCustom {
    String getLastname();

    String getFirstname();

    String getPassword();

    String getEmail();

    Timestamp getCreatedAt();

    Timestamp getUpdateAt();

    Set<Role> getRoles();

    String getEmailCode();

    boolean getAccountNonExpired();

    boolean getAccountNonLocked();

    boolean getCredentialsNonExpired();

    boolean getEnabled();

}
