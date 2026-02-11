package com.employee.constants;

import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import com.employee.service.EmailService;

@Component

public class UserCreatedListener {

    private final EmailService emailService;
   

    public UserCreatedListener(EmailService emailService) {
		super();
		this.emailService = emailService;
	}


	@EventListener
    public void handleUserCreated(UserCreatedEvent event) {

       // String token = tokenService.createToken(event.getUserId());

        //String resetLink =
              //  "https://gem.gov.in/reset-password?token=" + token;

        emailService.sendUserCreationMail(
                event.getEmail(),
                event.getUsername(),
                event.getTempPassword()
                
        );
    }
}

