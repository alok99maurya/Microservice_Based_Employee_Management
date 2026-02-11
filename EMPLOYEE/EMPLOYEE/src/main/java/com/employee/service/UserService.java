package com.employee.service;

import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

import com.employee.constants.UserCreatedEvent;
import com.employee.model.dto.CreateUserRequest;
import com.employee.model.entity.User;
import com.employee.repository.UserRepo;

@Service
public class UserService {

    private final UserRepo userRepository;
   
    private final ApplicationEventPublisher publisher;
    

    public UserService(UserRepo userRepository, ApplicationEventPublisher publisher) {
		super();
		this.userRepository = userRepository;
		this.publisher = publisher;
	}


	public void createUser(CreateUserRequest request) {

        

        User user = new User();
        user.setFirstName(request.getFirstName());
        user.setLastName(request.getLastName());
        user.setUsername(request.getUsername());
        user.setOfficialEmail(request.getOfficialEmail());
        user.setAadhaarLinkedMobileNumber(
                request.getAadhaarLinkedMobileNumber());
        user.setPassword("Gem@123");

        User savedUser = userRepository.save(user);

        publisher.publishEvent(
                new UserCreatedEvent(
                        savedUser.getId(),
                        savedUser.getUsername(),
                        savedUser.getOfficialEmail(),
                        savedUser.getPassword()
                )
        );
    }
}
