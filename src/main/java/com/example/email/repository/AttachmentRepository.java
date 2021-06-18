package com.example.email.repository;



import com.example.email.entity.Attachment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface AttachmentRepository extends JpaRepository<Attachment,Integer> {
}
