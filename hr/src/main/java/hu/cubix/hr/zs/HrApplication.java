package hu.cubix.hr.zs;

import java.time.LocalDate;
import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import hu.cubix.hr.zs.model.Employee;
import hu.cubix.hr.zs.service.SalaryService;

@SpringBootApplication
public class HrApplication implements CommandLineRunner {
	
	@Autowired
	SalaryService salaryService;

	public static void main(String[] args) {
		SpringApplication.run(HrApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		Employee e1 = new Employee(Long.valueOf(1), 1000, LocalDateTime.now());
		System.out.println("old salary: "+e1.getSalary());
		salaryService.setNewSalary(e1);
		System.out.println("new salary: "+e1.getSalary());
		
		e1 = new Employee(Long.valueOf(1), 1000, LocalDateTime.of(2010, 6, 13, 20, 15));
		System.out.println("old salary: "+e1.getSalary());
		salaryService.setNewSalary(e1);
		System.out.println("new salary: "+e1.getSalary());
		
	}

}
