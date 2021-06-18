package com.example.email.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.Entity;

@Data
@AllArgsConstructor
//@NoArgsConstructor
@Entity
public class Measurement extends Abctract {
    public Measurement(String name, boolean active) {
        super(name, active);
    }
}
