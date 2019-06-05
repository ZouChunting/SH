package action;

import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import pojo.House;
import pojo.Street;
import pojo.Type;
import service.HouseService;
import service.StreetService;
import service.TypeService;
import utils.Page;

import com.opensymphony.xwork2.ActionSupport;

public class HouseAction extends ActionSupport {
	//搜索房屋
	public String searchHouse() throws UnsupportedEncodingException{
		HttpServletRequest request=ServletActionContext.getRequest();
		HttpServletResponse response=ServletActionContext.getResponse();
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		HouseService hs=new HouseService();
		TypeService ts=new TypeService();
		StreetService ss=new StreetService();
		
		String title=request.getParameter("title");
		System.out.println("========================"+title);
		
		int street=Integer.parseInt(request.getParameter("street"));
		int type=Integer.parseInt(request.getParameter("type"));
		String floorage=request.getParameter("floorage");
		String price=request.getParameter("price");
		
		String pageno=request.getParameter("pageno");
		
		Page page=new Page();
		int pagesize=3;
		page.setPagesize(pagesize);
		int houseNumber=hs.selectSomeHomeNumber(title, street, type, floorage, price);
		page.setCountnumber(houseNumber);
		
		System.out.println(pageno);

		if(pageno==null){
			page.setPageno(1);
		}else{
			page.setPageno(Integer.parseInt(pageno));
		}
		request.setAttribute("page",page);
		//分页查询
		List<House> houses=hs.selectSomeHousePage(title, street, type, floorage, price, page.getPageno(), page.getPagesize());
		request.setAttribute("houses",houses);
		List<Type> types=ts.selectAllType();
		request.setAttribute("types",types);
		List<Street> streets=ss.selectAllStreet();
		request.setAttribute("streets",streets);
		return SUCCESS;
	}
	
	//显示房屋详情
	public String showHouseDetail() throws UnsupportedEncodingException{
		HttpServletRequest request=ServletActionContext.getRequest();
		HttpServletResponse response=ServletActionContext.getResponse();
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		HouseService hs=new HouseService();
		
		int id=Integer.parseInt(request.getParameter("id"));
		//根据id查询房屋
		House house=hs.showHouseDetail(id);
		request.setAttribute("house",house);
		return SUCCESS;
	}

}
