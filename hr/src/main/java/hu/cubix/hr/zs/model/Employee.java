package hu.cubix.hr.zs.model;

import java.time.LocalDateTime;

public class Employee {
	
	private Long id;
	private Integer salary;
	private LocalDateTime startDateTime;
	
	private static Long nextId = Long.valueOf(1);
	
	public static Long getNextId() {
		return nextId++;
	}
	
	public Employee(Long id, Integer salary, LocalDateTime startDateTime) {
		super();
		this.id = id;
		this.salary = salary;
		this.startDateTime = startDateTime;
	}
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public Integer getSalary() {
		return salary;
	}
	
	public void setSalary(Integer salary) {
		this.salary = salary;
	}
	
	public LocalDateTime getStartDateTime() {
		return startDateTime;
	}
	
	public void setStartDateTime(LocalDateTime startDateTime) {
		this.startDateTime = startDateTime;
		
	}
	
	

}
