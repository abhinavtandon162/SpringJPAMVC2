package com.cg.springmvcone.service;

import java.util.List;

import com.cg.springmvcone.dto.Employee;

public interface IServiceEmployee {
	
	public int addEmployeeData(Employee emp);
	public List<Employee> showAllEmployee();
	public void deleteEmployee(int empId);
	public void updateEmployee(Employee emp);
	public List <Employee> searchEmployee(int id);
	
	

}
