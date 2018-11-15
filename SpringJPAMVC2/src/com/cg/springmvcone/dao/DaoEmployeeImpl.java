package com.cg.springmvcone.dao;

import java.util.Iterator;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.cg.springmvcone.dto.Employee;

@Repository("employeedao")
public class DaoEmployeeImpl  implements IDaoEmployee{

	@PersistenceContext
	EntityManager entitymanager;
	
	@Override
	public int addEmployeeData(Employee emp) {
		
		System.out.println("Hi before persist");
		entitymanager.persist(emp);
		System.out.println("Hi after persist");
		entitymanager.flush();
		System.out.println("Hi after flush");
		return emp.getEmpId();
	}

	@Override
	public List<Employee> showAllEmployee() {
		Query queryOne = entitymanager.createQuery("FROM Employee");
		List<Employee> myList= queryOne.getResultList();
		
		return myList;
	}

	@Override
	public void deleteEmployee(int empId) {
		Query queryTwo = entitymanager.createQuery("DELETE FROM Employee WHERE empId=:eid");
		queryTwo.setParameter("eid", empId);
		queryTwo.executeUpdate();
		
	}

	@Override
	public void updateEmployee(Employee emp) {
		
		
	}

	@Override
	public List<Employee> searchEmployee(int id) {

		Query queryThree = entitymanager.createQuery("FROM Employee WHERE empId=:eid");
		queryThree.setParameter("eid", id);
		List<Employee> emp =  queryThree.getResultList();
		return emp;
	
		
	}

}
