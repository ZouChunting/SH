package action;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import pojo.User;
import service.UserService;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class UserAction extends ActionSupport implements ModelDriven<User> {
	private User user=new User();	
	public User getModel() {
		// TODO Auto-generated method stub
		return user;
	}
	
	//注册
	public String register() throws UnsupportedEncodingException{
		HttpServletRequest request=ServletActionContext.getRequest();
		HttpServletResponse response=ServletActionContext.getResponse();
		//设置编码
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		//注册，新增用户数据
		UserService us=new UserService();
		us.register(user);
		System.out.println("注册成功！");
		
		return SUCCESS;
	}
	
	//登录
	public String login() throws UnsupportedEncodingException{		
		HttpServletRequest request=ServletActionContext.getRequest();
		HttpServletResponse response=ServletActionContext.getResponse();
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		
		System.out.println(username+" "+password);
		
		HttpSession session=request.getSession();
		
		UserService us=new UserService();
		Map<String,Object> map =new HashMap<>();
		map.put("username", username);
		map.put("password", password);
		User user=us.login(map);
		if(user!=null){
			session.setAttribute("user", user);
			System.out.println("登录成功！");
			return SUCCESS;
		}else{
			System.out.println("登录失败！");
			return ERROR;
		}
	}

}
