package com.fuatkara.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {

	private static final SessionFactory sessionFactory = olusturSession();

	private static SessionFactory olusturSession() {
		try {
			return new Configuration().configure().buildSessionFactory();
		}
		catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}

	public static SessionFactory getSessionfactory() {
		return sessionFactory;
	}
	
	public static void Shutdown() {
		olusturSession().close();
	}
}

