package hu.cubix.hr.zs.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import hu.cubix.hr.zs.service.DefaultEmployeeService;
import hu.cubix.hr.zs.service.EmployeeService;

@Configuration
@Profile("!smart")
public class DefaultConfiguration {
	
	@Bean
	public EmployeeService employeeService() {
		return new DefaultEmployeeService();
	}

}
