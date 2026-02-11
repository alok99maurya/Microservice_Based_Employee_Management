package com.employee.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

    private final JavaMailSender mailSender;

    @Value("${spring.mail.username}")
    private String fromMail;
    

    public EmailService(JavaMailSender mailSender,
            @Value("${spring.mail.username}") String fromMail) {
this.mailSender = mailSender;
this.fromMail = fromMail;
}


	public void sendUserCreationMail(
            String to,
            String username,
            String tempPassword           
    ) {

        String subject = "GeM Portal Account Created";

        String body =
                "Dear User,\n\n" +
                "Congratulations!\n" +
                "Your user account has been created for GeM portal.\n\n" +
                "Username : " + username + "\n" +
                "Temporary Password : " + tempPassword + "\n\n" +
                "Please click here to reset your password within 7 days:\n" +
                 "\n\n" +
                "Regards\n" +
                "Team GeM";

        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(fromMail);
        message.setTo(to);
        message.setSubject(subject);
        message.setText(body);

        mailSender.send(message);
    }
}

