package com.example.email.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@EntityListeners(AuditingEntityListener.class)
public class InputProduct {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @ManyToOne
    private Input input;
    @OneToOne
    private Product product_id;
    private String amount;
    private String price;
    private LocalDate expire_date;
    @CreatedBy
    private UUID createdBy;
    @LastModifiedBy
    private UUID updatedBy;

    public InputProduct(Input input, Product product_id, String amount, String price, LocalDate expire_date) {
        this.input = input;
        this.product_id = product_id;
        this.amount = amount;
        this.price = price;
        this.expire_date = expire_date;
    }
}
