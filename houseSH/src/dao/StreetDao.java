package dao;

import java.util.List;

import org.hibernate.Query;

import common.HibernateSessionFactory;

import pojo.Street;

public class StreetDao {
	//查询所有街道信息
	public List<Street> selectAllStreet(){
		Query q= HibernateSessionFactory.getSession().createQuery("from Street");
		return q.list();
	}
	
	//根据区号查询街道信息
	public List<Street> selectStreetByDistrict(int district_id){
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("from Street");
		stringBuilder.append(" where district_id="+district_id);
		Query q= HibernateSessionFactory.getSession().createQuery(stringBuilder.toString());
		return q.list();
	}
}
