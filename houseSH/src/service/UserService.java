package service;

import java.util.Map;

import org.hibernate.HibernateException;
import org.hibernate.Transaction;

import common.HibernateSessionFactory;

import pojo.User;
import dao.UserDao;

public class UserService {
	UserDao ud=new UserDao();
	
	//注册用户
	public void register(User user){
		Transaction tx=null;
		try {
			tx=HibernateSessionFactory.getSession().beginTransaction();
			ud.saveUser(user);
			tx.commit();
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			if(tx!=null){
				tx.rollback();
			}
		}		
	}
	
	//登录
	public User login(Map<String,Object> map){
		User user=null;
		Transaction tx=null;
		try{
			tx=HibernateSessionFactory.getSession().beginTransaction();
			user=ud.login(map);
			tx.commit();
		} catch (HibernateException e) {
			e.printStackTrace();
			if(tx!=null){
				tx.rollback();
			}
		}
		
		return user;
	}
	
	
	
}
