package web;


import java.io.IOException;
import java.lang.reflect.Method;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class BaseServlet extends HttpServlet {

	//ͨ�õ�servlet����
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//�����Ժ�����з���ͬһ����������Ӧ���봦��
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		//��ȡ�û�����ķ���
		String methodName=request.getParameter("method");
		
		//�жϷ������Ƿ�Ϊ�� ""    null
		if(methodName.trim().isEmpty()||methodName==null){  
			throw new RuntimeException("��û�д���method����!�޷�ȷ����Ҫ���õķ���!");
		}
		
		//1.    ��ȡ��ǰ���class����
		Class c=this.getClass();
		
		//2.	ͨ��ǰ���class�����getMethod()���������Ƿ���ڶ�Ӧ����
		Method method=null;
		try {
			method=c.getMethod(methodName,HttpServletRequest.class,HttpServletResponse.class);
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("��Ҫ���õķ���"+methodName+"������!");
		}
		
		
		//3. ͨ���䶯̬�ĵ��ö�Ӧ�ķ���
		try {
			//��ȡ�����ķ���ֵ
			String result=(String)method.invoke(this, request,response);
			
			//�ж��Ƿ��з���ֵ   û�о�ʲô������
			if(result==null||result.trim().isEmpty()){
				return ;
			}
			
			//�鿴����ֵ�Ƿ��ð��,���ô�и��û����쳣
			//�����,ʹ��ð�Ž��зָ�  ǰ��[ת�����ض���ı�ʶ]����[��ת�ĵ�ַ]
			//��ת�����ض�����
			if(result.contains(":")){
				//���
				
				//��ȡð�ŵ�λ��
				int index=result.indexOf(":");
				//��ȡð��֮ǰ��
				String s=result.substring(0, index);
				//��ȡð��֮���
				String path=result.substring(index+1);
				
				if(s.equalsIgnoreCase("c")){
					//�ض���
					response.sendRedirect(request.getContextPath()+path);
				}else if(s.equalsIgnoreCase("z")){
					//ת��
					request.getRequestDispatcher(path).forward(request, response);
				}else{
					throw new RuntimeException("��ָ���Ĳ���"+s+"��ǰ�汾��֧��!");
				}
				
			}else{
				//û��ð��
				throw new RuntimeException("��ָ����ת��URL��������!");
				
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("��Ҫ���õķ���!"+methodName+"�ڲ���������!");
		}
	}


	
}
