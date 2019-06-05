package action;

import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import pojo.District;
import pojo.House;
import pojo.Street;
import pojo.Type;
import pojo.User;
import service.DistrictService;
import service.HouseService;
import service.StreetService;
import service.TypeService;
import utils.Page;

import com.opensymphony.xwork2.ActionSupport;

public class InitAction extends ActionSupport {
	//初始化首页
	public String initIndex() throws UnsupportedEncodingException{
		HttpServletRequest request=ServletActionContext.getRequest();
		HttpServletResponse response=ServletActionContext.getResponse();
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		HouseService hs=new HouseService();
		TypeService ts=new TypeService();
		StreetService ss=new StreetService();
		
		Page page=new Page();
		int pagesize=3;
		page.setPagesize(pagesize);
		int houseNumber=hs.selectGameNumber();
		page.setCountnumber(houseNumber);
		
		String pageno=request.getParameter("pageno");
		
		System.out.println(pageno);

		if(pageno==null){
			page.setPageno(1);
		}else{
			page.setPageno(Integer.parseInt(pageno));
		}
		request.setAttribute("page",page);
		//分页查询
		List<House> houses=hs.selectHousePage(page.getPageno(), page.getPagesize());
		request.setAttribute("houses",houses);
		List<Type> types=ts.selectAllType();
		request.setAttribute("types",types);
		List<Street> streets=ss.selectAllStreet();
		request.setAttribute("streets",streets);
		
		return SUCCESS;
	}
	
	//初始化个人发布页
	public String initMy() throws UnsupportedEncodingException{
		HttpServletRequest request=ServletActionContext.getRequest();
		HttpServletResponse response=ServletActionContext.getResponse();
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		HouseService hs=new HouseService();
		
		//获取登录用户信息
		HttpSession session=request.getSession();
		User user=(User) session.getAttribute("user");
		if(user==null){
			//未登录
			return ERROR;
		}else{
			//已登录
			int user_id=user.getId();
			System.out.println("========================"+user_id);
			
			Page page=new Page();
			int pagesize=3;
			page.setPagesize(pagesize);
			int houseNumber=hs.selectUserHouseNumber(user_id);
			page.setCountnumber(houseNumber);
			
			String pageno=request.getParameter("pageno");
			
			System.out.println(pageno);

			if(pageno==null){
				page.setPageno(1);
			}else{
				page.setPageno(Integer.parseInt(pageno));
			}
			System.out.println(page);
			request.setAttribute("page",page);
			
			//分页查询
			List<House> houses=hs.selectUserHousePage(user_id, page.getPageno(), page.getPagesize());
			request.setAttribute("houses",houses);
			return SUCCESS;
			
		}		
	}
	
	//初始化发布页
	public String initRelease(){
		HttpServletRequest request=ServletActionContext.getRequest();
		HttpServletResponse response=ServletActionContext.getResponse();
		
		TypeService ts=new TypeService();
		DistrictService ds=new DistrictService();
		List<Type> types=ts.selectAllType();
		List<District> districts=ds.selectAllDistrict();
		request.setAttribute("types",types);
		request.setAttribute("districts",districts);
		return SUCCESS;
	}
}
