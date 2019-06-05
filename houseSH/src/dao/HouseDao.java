package dao;

import java.util.List;
import java.util.Map;

import org.hibernate.Query;

import pojo.House;

import common.HibernateSessionFactory;

public class HouseDao {
	//查询房屋信息数量
	public int selectHouseNumber(){
		String hql="select count(id) from House";
		Query q= HibernateSessionFactory.getSession().createQuery(hql);
		Number count=(Number) q.uniqueResult();
		return count.intValue();
	}
	
	//查询符合条件的房屋信息数量
	public int selectSomeHouseNumber(String title,int street,int type,String floorage,String price){
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("select count(id) from House where 1=1");
		
		if(title!=null&&!title.trim().equals("")){
			stringBuilder.append(" and title like '%" + title+"%'");
		}
		
		if(street!=0){
			stringBuilder.append(" and street_id =" + street);
		}
		
		if(type!=0){
			stringBuilder.append(" and type_id =" + type);
		}
		
		String[] f=floorage.split("-");
		int a=Integer.parseInt(f[0]);
		int b=Integer.parseInt(f[1]);
		double aa=a+0.0;
		double bb=b+0.0;
		stringBuilder.append(" and floorage between " + aa+" and "+bb);
		
		String[] p=price.split("-");
		int c=Integer.parseInt(p[0]);
		int d=Integer.parseInt(p[1]);
		double cc=c+0.0;
		double dd=d+0.0;
		stringBuilder.append(" and price between " + cc+" and "+dd);
		
		Query q= HibernateSessionFactory.getSession().createQuery(stringBuilder.toString());
		Number count=(Number) q.uniqueResult();
		return count.intValue();
	}
	
	//查询用户房屋数量
	public int selectUserHouseNumber(int user_id){
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("select count(id) from House");
		stringBuilder.append(" where user_id="+user_id);
		Query q= HibernateSessionFactory.getSession().createQuery(stringBuilder.toString());
		Number count=(Number) q.uniqueResult();
		return count.intValue();
	}
	
	//分页查询
	public List<House> selectHousePage(int pageno,int pagesize){
		String hql="from House";
		Query q= HibernateSessionFactory.getSession().createQuery(hql);
		q.setFirstResult((pageno-1)*pagesize);
		q.setMaxResults(pagesize);
		return q.list();
	}
	
	//根据用户id查询房屋信息并分页
	public List<House> selectUserHousePage(int user_id,int pageno,int pagesize){
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("from House");
		stringBuilder.append(" where user_id="+user_id);
		Query q= HibernateSessionFactory.getSession().createQuery(stringBuilder.toString());
		q.setFirstResult((pageno-1)*pagesize);
		q.setMaxResults(pagesize);
		return q.list();
	}
	
	//带条件并分页查询
	public List<House> selectSomeHousePage(String title,int street,int type,String floorage,String price,int pageno,int pagesize){
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("from House");
		stringBuilder.append(" where 1=1");
		
		if(title!=null&&!title.trim().equals("")){
			stringBuilder.append(" and title like '%" + title+"%'");
		}
		
		if(street!=0){
			stringBuilder.append(" and street_id =" + street);
		}
		
		if(type!=0){
			stringBuilder.append(" and type_id =" + type);
		}
		
		String[] f=floorage.split("-");
		int a=Integer.parseInt(f[0]);
		int b=Integer.parseInt(f[1]);
		double aa=a+0.0;
		double bb=b+0.0;
		stringBuilder.append(" and floorage between " + aa+" and "+bb);
		
		String[] p=price.split("-");
		int c=Integer.parseInt(p[0]);
		int d=Integer.parseInt(p[1]);
		double cc=c+0.0;
		double dd=d+0.0;
		stringBuilder.append(" and price between " + cc+" and "+dd);
		
		Query q= HibernateSessionFactory.getSession().createQuery(stringBuilder.toString());
		q.setFirstResult((pageno-1)*pagesize);
		q.setMaxResults(pagesize);
		return q.list();
	}
	
	//根据id查询房屋
	public House selectHouseById(int id){
		return (House)HibernateSessionFactory.getSession().get(House.class,id);	
	}
}
