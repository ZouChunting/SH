package common;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateSessionFactory {
	
	private static Configuration cfg;
	
	private static SessionFactory sessionFactory;
	
	static{
		try {
			
			cfg=new Configuration().configure();
			
			sessionFactory=cfg.buildSessionFactory();
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("工厂创建失败");
		}
	}	
	
	public static Session getSession(){
		//<property name="current_session_context_class">thread</property>
		return sessionFactory.getCurrentSession();
	}
	
}
