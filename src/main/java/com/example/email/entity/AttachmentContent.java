package com.example.email.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class AttachmentContent {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private byte[] bytes;
    @OneToOne
    private Attachment attachment ;

    public AttachmentContent(byte[] bytes, Attachment attachment) {
        this.bytes = bytes;
        this.attachment = attachment;
    }
}
