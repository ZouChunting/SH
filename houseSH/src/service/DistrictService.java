package service;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Transaction;

import common.HibernateSessionFactory;
import dao.DistrictDao;

import pojo.District;

public class DistrictService {
	DistrictDao dd=new DistrictDao();
	
	//查询所有区信息
	public List<District> selectAllDistrict(){
		List<District> districts=new ArrayList<District>();
		Transaction tx=null;
		try {
			//获得事务
			tx=HibernateSessionFactory.getSession().beginTransaction();
			//调用dao方法
			districts=dd.selectAllDistrict();
			//提交事务
			tx.commit();
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			if(tx!=null){
				tx.rollback();
			}
		}
		return districts;
	}
}
