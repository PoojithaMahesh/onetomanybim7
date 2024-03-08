package onetomany.controller;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import onetomany.dto.Company;
import onetomany.dto.Employee;

public class CompEmpController {
public static void main(String[] args) {
	
	Company company=new Company();
	company.setId(1);
	company.setName("MithilaPVT");
	company.setGst("MST");
	
	
	Employee employee1=new Employee();
	employee1.setId(1);
	employee1.setName("jayam");
	employee1.setAddress("Pune");
	
	employee1.setCompany(company);
	
	Employee employee2=new Employee();
	employee2.setId(2);
	employee2.setName("bhuvan");
	employee2.setAddress("Pune");
	
	employee2.setCompany(company);
	
	List<Employee> employees=new ArrayList<Employee>();
	employees.add(employee1);
	employees.add(employee2);
	
	company.setEmployees(employees);
	
	
	EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("vinod");
	EntityManager entityManager=entityManagerFactory.createEntityManager();
	EntityTransaction entityTransaction=entityManager.getTransaction();
	entityTransaction.begin();
	entityManager.persist(employee1);
	entityManager.persist(employee2);
	entityManager.persist(company);
	entityTransaction.commit();
	
	
	
	
	
	
	
}
}
