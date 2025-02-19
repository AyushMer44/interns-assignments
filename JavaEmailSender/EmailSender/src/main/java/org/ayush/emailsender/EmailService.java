package org.ayush.emailsender;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import java.io.File;

@Service
public class EmailService {

    @Autowired
    private JavaMailSender mailSender;

    public void sendEmailWithAttachment(String toEmail, String subject, String body, String attachmentPath) throws MessagingException {
        MimeMessage message = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, true);

        helper.setTo(toEmail);
        helper.setSubject(subject);
        helper.setText(body, true);
        helper.setFrom("ayushmer5@gmail.com"); // Replace with your email

        System.out.println("Attachment Path: "+attachmentPath);

        // Attach image
        File file = new File(attachmentPath);
//        if (file.exists() && isValidImage(file)) {
//            FileSystemResource resource = new FileSystemResource(file);
//            helper.addAttachment(file.getName(), resource);
//        } else {
//            throw new MessagingException("Invalid image file format. Only PNG, JPG, and JPEG are allowed.");
//        }

        System.out.println("File: "+file.getAbsolutePath());

        if(!file.exists()){
            throw new MessagingException("Image File not found");
        }

        else if(!isValidImage(file)){
            throw new MessagingException("Invalid image file format. Only PNG, JPG, and JPEG are allowed.");
        }

        else{
            FileSystemResource resource = new FileSystemResource(file);
            helper.addAttachment(file.getName(), resource);
        }

        mailSender.send(message);
        System.out.println("Email sent successfully!");
    }

    private boolean isValidImage(File file) {
        String[] allowedExtensions = {".png", ".jpg", ".jpeg"};
        for (String ext : allowedExtensions) {
            if (file.getName().toLowerCase().endsWith(ext)) {
                return true;
            }
        }
        return false;
    }
}
