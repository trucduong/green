package com.green.hibernate.dao;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.green.hibernate.entity.Employee;
import com.green.hibernate.utill.HibernateUtils;

public class EmployeeDao {

	public List<Employee> findAll() {
		SessionFactory factory = HibernateUtils.getSessionFactory();
		Session session = factory.openSession();
		Query query = session.createQuery("from Employee");
		List<Employee> result = query.getResultList();
		return result;
	}
	
	public Employee find(int id) {
		SessionFactory factory = HibernateUtils.getSessionFactory();
		Session session = factory.openSession();

		Employee employee = session.find(Employee.class, id);
		
		return employee;
	}

	public boolean insert(Employee employee) {
		boolean result = true;
		try {

			SessionFactory factory = HibernateUtils.getSessionFactory();
			Session session = factory.openSession();
			session.beginTransaction();

			session.save(employee);

			session.getTransaction().commit();
			session.close();

		} catch (Exception e) {
			e.printStackTrace();
			result = false;
		}
		
		return result;
	}

	public boolean update(Employee employee) {
		boolean result = true;
		try {

			SessionFactory factory = HibernateUtils.getSessionFactory();
			Session session = factory.openSession();
			session.beginTransaction();

			session.update(employee);

			session.getTransaction().commit();
			session.close();

		} catch (Exception e) {
			e.printStackTrace();
			result = false;
		}
		
		return result;
	}

	public boolean delete(int id) {
		boolean result = true;
		try {

			SessionFactory factory = HibernateUtils.getSessionFactory();
			Session session = factory.openSession();
			session.beginTransaction();

			Employee employee = session.find(Employee.class, id);
			session.delete(employee);

			session.getTransaction().commit();
			session.close();

		} catch (Exception e) {
			e.printStackTrace();
			result = false;
		}
		
		return result;
	}
}
