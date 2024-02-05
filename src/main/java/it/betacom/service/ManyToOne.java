package it.betacom.service;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import it.betacom.entity.Department;
import it.betacom.entity.Employee;

public class ManyToOne {

	public static void main(String[] args) {

		EntityManagerFactory emFactory = Persistence.createEntityManagerFactory("JPAMTO");
		EntityManager entityManager = emFactory.createEntityManager();
		entityManager.getTransaction().begin();
		
		Department department = new Department();
		department.setName("Development");
		
		entityManager.persist(department);
		
		Employee employee = new Employee();
		employee.setEname("Luca");
		employee.setSalary(4000);
		employee.setDeg("Technical Writer");
		employee.setDepartment(department);
		
		Employee employee2 = new Employee();
		employee2.setEname("Daniele");
		employee2.setSalary(3000);
		employee2.setDeg("Analyst");
		employee2.setDepartment(department);
		
		Employee employee3 = new Employee();
		employee3.setEname("Giuseppe");
		employee3.setSalary(5000);
		employee3.setDeg("Team Leader");
		employee3.setDepartment(department);
		
		entityManager.persist(employee);
		entityManager.persist(employee2);
		entityManager.persist(employee3);
		
		entityManager.getTransaction().commit();
		entityManager.close();
		emFactory.close();
		
	}

}
