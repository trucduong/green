package com.green.example.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class BaseDao<E, K extends Serializable> {

	@Autowired
	private SessionFactory sessionFactory;

	protected abstract Class<E> getEntityClass();

	public E create(E entity) {
		Session session = this.sessionFactory.getCurrentSession();
		try {
			session.beginTransaction();
			session.save(entity);
			session.getTransaction().commit();
		} catch (Exception e) {
			System.out.println("Error during create " + entity.toString());
		} finally {
			session.close();
		}
		return entity;
	}

	public Boolean edit(E entity) {
		Session session = this.sessionFactory.getCurrentSession();
		try {
			session.beginTransaction();
			session.update(entity);
			session.getTransaction().commit();
			return Boolean.TRUE;
		} catch (Exception e) {
			System.out.println("Error during edit " + entity.toString());
			return Boolean.FALSE;
		} finally {
			session.close();
		}
	}

	public Boolean remove(E entity) {
		Session session = this.sessionFactory.getCurrentSession();
		try {
			session.beginTransaction();
			session.delete(entity);
			session.getTransaction().commit();
			return Boolean.TRUE;
		} catch (Exception e) {
			System.out.println("Error during remove " + entity.toString());
			return Boolean.FALSE;
		} finally {
			session.close();
		}
	}

	public E get(K id) {
		Session session = this.sessionFactory.getCurrentSession();
		try {
			session.beginTransaction();
			return session.get(getEntityClass(), id);
		} catch (Exception e) {
			System.out.println("Error during finding. . .");
		} finally {
			session.close();
		}
		return null;
	}

	public List<E> getAll() {
		Session session = this.sessionFactory.getCurrentSession();
		try {
			session.beginTransaction();
			Query query = session.createQuery("from " + getEntityClass());
			return query.getResultList();
		} catch (Exception e) {
			System.out.println("Error during find " + getEntityClass().getName());
		} finally {
			session.close();
		}
		return null;
	}

	public Boolean remove(K id) {
		Session session = this.sessionFactory.getCurrentSession();
		session.beginTransaction();
		E entity = (E) session.load(getEntityClass(), id);
		if (null != entity) {
			session.delete(entity);
			session.getTransaction().commit();
			session.close();
			return Boolean.TRUE;
		}
		session.close();
		return Boolean.FALSE;
	}
}
