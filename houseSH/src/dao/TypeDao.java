package dao;

import java.util.List;

import org.hibernate.Query;

import common.HibernateSessionFactory;

import pojo.Type;

public class TypeDao {
	//查询所有类型
	public List<Type> selectAllType(){
		Query q= HibernateSessionFactory.getSession().createQuery("from Type");
		return q.list();
	}
}
