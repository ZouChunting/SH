package dao;

import java.util.Map;

import org.hibernate.Query;

import common.HibernateSessionFactory;

import pojo.User;

public class UserDao {
	//新增用户
	public void saveUser(User user){
		HibernateSessionFactory.getSession().save(user);
	}
	
	//根据用户名查询用户
	public User login(Map<String,Object> map){
		Query q= HibernateSessionFactory.getSession().createQuery("from User where username=:username and password=:password ");
		q.setProperties(map);
		return (User) q.uniqueResult();
	}
}
