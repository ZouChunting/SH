package dao;

import java.util.List;

import org.hibernate.Query;

import common.HibernateSessionFactory;

import pojo.District;

public class DistrictDao {
	//查询所有区信息
	public List<District> selectAllDistrict(){
		String hql="from District";
		Query q= HibernateSessionFactory.getSession().createQuery(hql);
		return q.list();
	}
}
