package service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.hibernate.HibernateException;
import org.hibernate.Transaction;

import pojo.House;

import common.HibernateSessionFactory;

import dao.HouseDao;

public class HouseService {
	HouseDao hd=new HouseDao();
	
	//查询房屋信息数量
	public int selectGameNumber(){
		int houseNumber=0;
		Transaction tx=null;
		try {
			//获得事务
			tx=HibernateSessionFactory.getSession().beginTransaction();
			//调用dao方法
			houseNumber=hd.selectHouseNumber();
			//提交事务
			tx.commit();
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			if(tx!=null){
				tx.rollback();
			}
		}
		return houseNumber;
	}
	
	//查询某些房屋数量
	public int selectSomeHomeNumber(String title,int street,int type,String floorage,String price){
		int houseNumber=0;
		Transaction tx=null;
		try {
			//获得事务
			tx=HibernateSessionFactory.getSession().beginTransaction();
			//调用dao方法
			houseNumber=hd.selectSomeHouseNumber(title, street, type, floorage, price);
			//提交事务
			tx.commit();
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			if(tx!=null){
				tx.rollback();
			}
		}
		return houseNumber;
	}
	
	//查询用户房屋数量
	public int selectUserHouseNumber(int user_id){
		int houseNumber=0;
		Transaction tx=null;
		try {
			//获得事务
			tx=HibernateSessionFactory.getSession().beginTransaction();
			//调用dao方法
			houseNumber=hd.selectUserHouseNumber(user_id);
			//提交事务
			tx.commit();
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			if(tx!=null){
				tx.rollback();
			}
		}
		return houseNumber;
	}
	
	//分页查询
	public List<House> selectHousePage(int pageno,int pagesize){
		List<House> houses=new ArrayList<House>();
		Transaction tx=null;
		try {
			//获得事务
			tx=HibernateSessionFactory.getSession().beginTransaction();
			//调用dao方法
			houses=hd.selectHousePage(pageno, pagesize);
			//提交事务
			tx.commit();
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			if(tx!=null){
				tx.rollback();
			}
		}
		return houses;
		
	}
	
	//查询用户房屋信息并分页
	public List<House> selectUserHousePage(int user_id,int pageno,int pagesize){
		List<House> houses=new ArrayList<House>();
		Transaction tx=null;
		try {
			//获得事务
			tx=HibernateSessionFactory.getSession().beginTransaction();
			//调用dao方法
			houses=hd.selectUserHousePage(user_id, pageno, pagesize);
			//提交事务
			tx.commit();
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			if(tx!=null){
				tx.rollback();
			}
		}
		return houses;
	}
	
	//带条件分页查询
	public List<House> selectSomeHousePage(String title,int street,int type,String floorage,String price,int pageno,int pagesize){
		List<House> houses=new ArrayList<House>();
		Transaction tx=null;
		try {
			//获得事务
			tx=HibernateSessionFactory.getSession().beginTransaction();
			//调用dao方法
			houses=hd.selectSomeHousePage(title, street, type, floorage, price, pageno, pagesize);
			//提交事务
			tx.commit();
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			if(tx!=null){
				tx.rollback();
			}
		}
		return houses;
	}
	
	//根据id查询房屋信息
	public House showHouseDetail(int id){
		House house=new House();
		Transaction tx=null;
		try {
			//获得事务
			tx=HibernateSessionFactory.getSession().beginTransaction();
			//调用dao方法
			house=hd.selectHouseById(id);
			//提交事务
			tx.commit();
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			if(tx!=null){
				tx.rollback();
			}
		}
		return house;
	}
	
	
}
