package com.address.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.address.AddressApplication;


@Configuration
public class AppConfig {
	
	

	    private final AddressApplication addressApplication;

	    AppConfig(AddressApplication addressApplication) {
	        this.addressApplication = addressApplication;
	    }
		
	    @Bean
		public ModelMapper modelMapper() {
			ModelMapper modelMapper = new ModelMapper();
			modelMapper.getConfiguration().setFieldAccessLevel(org.modelmapper.config.Configuration.AccessLevel.PRIVATE)
			.setFieldMatchingEnabled(true);
			return modelMapper;
		}


}
