package hy.utils;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtils {
	static Configuration cfg=null;
	static SessionFactory sessionFactory=null;
	
	static {
		cfg=new Configuration();
		cfg.configure();
		sessionFactory=cfg.buildSessionFactory();
	}
	public static SessionFactory getSessionFactory() {
		return sessionFactory;
		
	}
	//提供返回线程局部变量的session方法
	public static Session getSessionObject() {
		return sessionFactory.getCurrentSession();
	}

}
