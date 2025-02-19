package org.ayush.emailsender;

import jakarta.mail.MessagingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/email")
public class EmailController {

    @Autowired
    private EmailService emailService;

    @PostMapping("/send")
    public String sendEmail() {
        String toEmail = "hr@ignitershub.com";
        String subject = "Challenge 3 Completed";
//        String body = "Name: Ayush Mer\nSemester: 8th\nBranch: Computer Science and Engineering\nRoll Number: 210180101010";
        String body = """
                Hello HR Team,
                
                I have completed Challenge 3.
                
                Name: Ayush Mer, 
                Semester: 8th , 
                Branch: Computer Science and Engineering, 
                Roll Number: 210180101010 
                
                Please find the attached image.
                
                Regards, 
                Ayush Mer
                """;
        String attachmentPath = "src/main/resources/static/passport.png";

        try {
            emailService.sendEmailWithAttachment(toEmail, subject, body, attachmentPath);
            return "Email sent successfully!";
        } catch (MessagingException e) {
            return "Failed to send email: " + e.getMessage();
        }
    }
}
