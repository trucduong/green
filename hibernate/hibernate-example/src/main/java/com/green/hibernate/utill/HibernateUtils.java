package com.green.hibernate.utill;

import org.apache.log4j.Logger;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class HibernateUtils {
	private static Logger logger = Logger.getLogger(HibernateUtils.class);

	private static SessionFactory sessionFactory;

	static {
		try {

			StandardServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
					.configure("hibernate/hibernate.cfg.xml").build();
			Metadata metadata = new MetadataSources(serviceRegistry).getMetadataBuilder().build();
			sessionFactory = metadata.getSessionFactoryBuilder().build();

		} catch (Exception e) {
			e.printStackTrace();
			logger.error("Can't init session factory", e);
		}
	}

	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}
}