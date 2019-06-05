package service;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Transaction;

import common.HibernateSessionFactory;

import pojo.Street;

import dao.StreetDao;

public class StreetService {
	StreetDao sd=new StreetDao();
	
	//查询所有街道信息
	public List<Street> selectAllStreet(){
		List<Street> streets=new ArrayList<Street>();
		Transaction tx=null;
		try {
			//获得事务
			tx=HibernateSessionFactory.getSession().beginTransaction();
			//调用dao方法
			streets=sd.selectAllStreet();
			//提交事务
			tx.commit();
		} catch (HibernateException e) {
			e.printStackTrace();
			if(tx!=null){
				tx.rollback();
			}
		}
		return streets;
	}
	
	//根据区号查询街道信息
	public List<Street> selectStreetByDistrict(int district_id){
		List<Street> streets=new ArrayList<Street>();
		Transaction tx=null;
		try {
			//获得事务
			tx=HibernateSessionFactory.getSession().beginTransaction();
			//调用dao方法
			streets=sd.selectStreetByDistrict(district_id);
			//提交事务
			tx.commit();
		} catch (HibernateException e) {
			e.printStackTrace();
			if(tx!=null){
				tx.rollback();
			}
		}
		return streets;
	}
}
