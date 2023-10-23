package hu.cubix.hr.zs.service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import hu.cubix.hr.zs.config.HrConfigurationProperties;
import hu.cubix.hr.zs.model.Employee;

@Configuration
@Profile("smart")
public class SmartEmployeeService implements EmployeeService{
	
	@Autowired
	HrConfigurationProperties hrConfigurationProperties;

	@Override
	public int getPayRaisePercent(Employee employee) {

		LocalDate date1 = LocalDate.now();
		LocalDate date2 = employee.getStartDateTime().toLocalDate();
//		
//		Period period = Period.between(date1, date2);
//		
//		int years = Math.abs(period.getYears());
//		int months = Math.abs(period.getMonths());
//		int days = Math.abs(period.getDays());
//		
//		int totalDays = years * 365 + months * 30 + days;
//		double yearsWorked = Double.valueOf(totalDays) / 365.0;
		
		double yearsWorked = ChronoUnit.DAYS.between(employee.getStartDateTime(), LocalDateTime.now()) / 365.0;
		
//		System.out.printf("totalDays: %s\n", totalDays);
		System.out.printf("dYear: %s\n", yearsWorked);
		System.out.printf("Today: %s\n", date1);
		System.out.printf("employee: %s\n", date2);

		if ( yearsWorked >= hrConfigurationProperties.getSalary().getSpecial().getLimit1()) {
			return 10;
		}
		if ( yearsWorked >= hrConfigurationProperties.getSalary().getSpecial().getLimit2())  {
			return 5;
		}
		if ( yearsWorked > hrConfigurationProperties.getSalary().getSpecial().getLimit3())  {
			return 2;
		}
		return hrConfigurationProperties.getSalary().getSpecial().getPercentDefault();
	}

}
