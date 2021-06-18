package com.example.email.service;


import com.example.email.entity.Attachment;
import com.example.email.entity.AttachmentContent;
import com.example.email.repository.AttachmentContentRepository;
import com.example.email.repository.AttachmentRepository;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Iterator;
import java.util.Optional;

@Service
public class AttachmentService {
    @Autowired
    AttachmentRepository attachmentRepository;
    @Autowired
    AttachmentContentRepository attachmentContentRepository;

    @SneakyThrows
    public String uploadDb(MultipartHttpServletRequest request) {
        Iterator<String> fileNames = request.getFileNames();
        int i = 0, j = 0;
        while (fileNames.hasNext()) {
            j = j + 1;
            MultipartFile file = request.getFile(fileNames.next());
            if (file != null) {
                i = i + 1;
              Attachment attachment = new Attachment(file.getOriginalFilename(), (int)file.getSize(), file.getContentType());
                attachmentRepository.save(attachment);
                AttachmentContent attachmentContent = new AttachmentContent(file.getBytes(), attachment);
                attachmentContentRepository.save(attachmentContent);
            }
        }
        return j + " tadan " + i + " ta fayl saqlandi";
    }

    public void getDbId(@PathVariable Integer id, HttpServletResponse response) throws IOException {
        Optional<Attachment> optionalAttachment = attachmentRepository.findById(id);
        if (optionalAttachment.isPresent()) {
            Attachment attachment = optionalAttachment.get();
            Optional<AttachmentContent> byAttachmentId = attachmentContentRepository.findByAttachmentId(id);
            if (byAttachmentId.isPresent()) {
                response.setHeader("Content-Disposition", "attachment;filename=\"" + attachment.getName() + "\"");
                response.setContentType(attachment.getContent_type());
                FileCopyUtils.copy(byAttachmentId.get().getBytes(), response.getOutputStream());
            }
        }


    }
    public String deleteAttachment(Integer id) {
        Optional<Attachment> optional = attachmentRepository.findById(id);
        if (optional.isPresent()) {
            Optional<AttachmentContent> optional1 = attachmentContentRepository.findByAttachmentId(id);
            if (optional1.isPresent()) {
                attachmentContentRepository.delete(optional1.get());
                attachmentRepository.deleteById(id);
                return "O'chirildi";
            }else {
                return "Bunday AttachmentContent topilmadi !!!";
            }
        }else {
            return "Bunday Attachment topilmadi !!!";
        }
    }
    public String update(Integer id,MultipartHttpServletRequest request) throws IOException {
        Optional<Attachment> optional = attachmentRepository.findById(id);
        if (optional.isPresent()) {
            Optional<AttachmentContent> optional1 = attachmentContentRepository.findByAttachmentId(id);
            if (optional1.isPresent()) {
                Iterator<String> fileNames = request.getFileNames();
                MultipartFile file = request.getFile(fileNames.next());
                AttachmentContent attachmentContent= optional1.get();
                Attachment attachment= optional.get();
                attachment.setContent_type(file.getContentType());
                attachment.setName(file.getOriginalFilename());
                attachment.setSize((int) file.getSize());
                attachmentRepository.save(attachment);
                attachmentContent.setAttachment(attachment);
                attachmentContent.setBytes(file.getBytes());
                attachmentContentRepository.save(attachmentContent);
                return "Yangilandi";
            }else {
                return "Bunday AttachmentContent topilmadi !!!";
            }
        }else {
            return "Bunday Attachment topilmadi !!!";
        }
    }
}
