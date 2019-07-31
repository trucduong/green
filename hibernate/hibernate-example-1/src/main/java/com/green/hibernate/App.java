package com.green.hibernate;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.green.hibernate.entity.Address;
import com.green.hibernate.entity.Student;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	// select all
//    	findAllExample();
    	findByNameExample();
    	
        // insert
//    	insertExample();
//    	insertExample2();
//    	insertExample3();
    	
    	// update
    	
    	// delete
//    	deleteExample();
    }
    
    public static void findAllExample() {
    	SessionFactory factory = HibernateUtils.getSessionFactory();
    	Session session = factory.openSession();
    	Query query = session.createQuery("from Student");
    	
    	List<Student> result = query.getResultList();
    	
    	System.out.println("Total: " + result.size());
    	
    	for (Student student : result) {
			System.out.println(student.toString());
		}
    	
    	session.close();
    }
    
    public static void findByNameExample() {
    	String nameToFind = "%truc%";
    	
    	SessionFactory factory = HibernateUtils.getSessionFactory();
    	Session session = factory.openSession();
    	Query query = session.createQuery("from Student where name like :name");
    	query.setParameter("name", nameToFind);
    	
    	List<Student> result = query.getResultList();
    	
    	System.out.println("Total: " + result.size());
    	
    	for (Student student : result) {
			System.out.println(student.toString());
		}
    	
    	session.close();
    }
    
    /**
     * insert student voi dia chi da co truoc
     */
    public static void insertExample() {
    	Student student = new Student();
    	student.setName("Cong Dat");
    	
    	Address address = new Address();
    	address.setId(1);
  
    	student.setAddress(address);
    	
    	SessionFactory factory = HibernateUtils.getSessionFactory();
    	Session session = factory.openSession();
    	session.save(student);
    	session.close();
    }
    
    /**
     * insert student voi dia chi da co truoc
     */
    public static void insertExample2() {
    	SessionFactory factory = HibernateUtils.getSessionFactory();
    	Session session = factory.openSession();
    	
    	Address address = session.find(Address.class, 1L);
    	
    	Student student = new Student();
    	student.setName("Cong Dat");
    	student.setAddress(address);
    	
    	session.save(student);
    	
    	session.close();
    }
    
    /**
     * insert student voi dia chi chua co trong DB
     */
    public static void insertExample3() {
    	SessionFactory factory = HibernateUtils.getSessionFactory();
    	Session session = factory.openSession();
    	
    	// tao address
    	Address address = new Address();
    	address.setCity("Ha Noi");
    	address.setState("Ba Dinh");
    	address.setStreet("Dong Khoi");
    	address.setZipcode("10000");
    	
    	session.save(address);
    	
    	// tao student
    	Student student = new Student();
    	student.setName("Cong Dat");
    	student.setAddress(address);
    	
    	session.save(student);
    	
    	session.close();
    }
    
    public static void updateExample() {
    	SessionFactory factory = HibernateUtils.getSessionFactory();
    	Session session = factory.openSession();
    	
    	// tim student can update
    	// vi du, update student voi id = 1
    	Student student = session.find(Student.class, 1l);
    	
    	// gan thong tin can update
    	// vi du thay doi ten
    	student.setName("Duong Thanh Truc");
    	
    	session.update(student);
    	
    	session.close();
    }
    
    /**
     * update by HQL
     */
    public static void updateExample1() {
    	SessionFactory factory = HibernateUtils.getSessionFactory();
    	Session session = factory.openSession();
    	
    	String hql = "update Student set name = :_name where id = :_id";
    	Query query = session.createQuery(hql);
    	query.setParameter("_id", 1L);
    	query.setParameter("_name", "Duong Thanh Truc");
    	
    	query.executeUpdate();
    	
    	session.close();
    }
    
    public static void deleteExample() {
    	SessionFactory factory = HibernateUtils.getSessionFactory();
    	Session session = factory.openSession();
    	session.beginTransaction();
    	
    	// tim student can delete
    	// vi du, delete student voi id = 1
    	Student student = session.find(Student.class, 1l);
    	
    	session.delete(student);
    	
    	session.getTransaction().commit();
    	session.close();
    }
}
