package com.employee.config;

import com.employee.EmployeeApplication;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    private final EmployeeApplication employeeApplication;

    AppConfig(EmployeeApplication employeeApplication) {
        this.employeeApplication = employeeApplication;
    }
	
    @Bean
	public ModelMapper modelMapper() {
		ModelMapper modelMapper = new ModelMapper();
		modelMapper.getConfiguration().setFieldAccessLevel(org.modelmapper.config.Configuration.AccessLevel.PRIVATE)
		.setFieldMatchingEnabled(true);
		return modelMapper;
	}

}
