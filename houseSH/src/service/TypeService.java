package service;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Transaction;

import common.HibernateSessionFactory;

import pojo.Type;

import dao.TypeDao;

public class TypeService {
	TypeDao td=new TypeDao();
	
	//查询所有类型
	public List<Type> selectAllType(){
		List<Type> types=new ArrayList<Type>();
		Transaction tx=null;
		try {
			//获得事务
			tx=HibernateSessionFactory.getSession().beginTransaction();
			//调用dao方法
			types=td.selectAllType();
			//提交事务
			tx.commit();
		} catch (HibernateException e) {
			e.printStackTrace();
			if(tx!=null){
				tx.rollback();
			}
		}
		return types;
	}
}
