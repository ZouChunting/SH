package action;

import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import pojo.Street;

import service.StreetService;

import com.opensymphony.xwork2.ActionSupport;

public class StreetAction extends ActionSupport {
	//根据区号查询街道
	public String selectStreetByDistrict() throws UnsupportedEncodingException{
		HttpServletRequest request=ServletActionContext.getRequest();
		HttpServletResponse response=ServletActionContext.getResponse();
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		int district_id=Integer.parseInt(request.getParameter("district_id"));
		
		StreetService ss=new StreetService();
		List<Street> streets=ss.selectStreetByDistrict(district_id);
		
		request.setAttribute("streets",streets);
		
		return SUCCESS;
	}
}
