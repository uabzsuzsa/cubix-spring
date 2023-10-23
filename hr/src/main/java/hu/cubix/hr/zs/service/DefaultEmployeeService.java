package hu.cubix.hr.zs.service;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import hu.cubix.hr.zs.model.Employee;

@Configuration
@Profile("!smart")
public class DefaultEmployeeService implements EmployeeService{

	@Override
	public int getPayRaisePercent(Employee employee) {
		return 5;
	}

}
