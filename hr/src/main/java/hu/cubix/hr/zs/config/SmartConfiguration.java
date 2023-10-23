package hu.cubix.hr.zs.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;


import hu.cubix.hr.zs.service.EmployeeService;
import hu.cubix.hr.zs.service.SmartEmployeeService;

@Configuration
@Profile("smart")
public class SmartConfiguration {
	
	@Bean
	public EmployeeService employeeService() {
		return new SmartEmployeeService();
	}

}
