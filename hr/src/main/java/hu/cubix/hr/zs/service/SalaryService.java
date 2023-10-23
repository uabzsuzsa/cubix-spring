package hu.cubix.hr.zs.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hu.cubix.hr.zs.model.Employee;

@Service
public class SalaryService {
	
	@Autowired
	EmployeeService employeeService;
	
	public void setNewSalary(Employee employee) {
		int percent = employeeService.getPayRaisePercent(employee);
		if ( percent > 0 ) {
			Integer newSalary = employee.getSalary().intValue() + ((employee.getSalary().intValue()*percent)/100);
			employee.setSalary(newSalary);
		}
	}
	
	

}
