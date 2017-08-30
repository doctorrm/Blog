/**
 * 
 */
package com.component.blog;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import po.HibernateUtil;
import po.blog;

/**
 * @author Doctor_
 * 2017-3-5  	����10:16:44
 */
//���������������'��ҳ'��'��������'�е���������Ӻ���ת��������ʾ������ϸ���ݵģ����servlet�䵱һ�����棬index.jsp�Ĳ�������-to-HERE
//���ܣ���ʾ���ĵ���ϸ����
public class BlogDetailedContent extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public BlogDetailedContent() {
		super();
	}

	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}


	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//��ȡ������ɫ�����ŵ�int
		String id=request.getParameter("id");
		 int int_id = Integer.valueOf(id).intValue();
		request.setAttribute("int_id",int_id);//����jsp������ɫ���
		
		//���µĴ��붼Ҫ��������������棡���򲻿��ԣ�
				SessionFactory sessionFactory=HibernateUtil.getSessionFactory();
				Session session=sessionFactory.openSession();
				response.setContentType("text/html;charset=utf-8");
				
				if(int_id==1){
					request.getRequestDispatcher("/nav1.jsp").include(request,response);
				}
				else{
				request.getRequestDispatcher("/nav2.jsp").include(request,response);
				}
				
	  PrintWriter out = response.getWriter();	
	  String topage=request.getParameter("toPage");//topage��һ���ַ������������ӵ����
	  int topa = Integer.valueOf(topage).intValue();
	  //int topa=(Integer)parsetoInteger(topage);//��������⣡�����ᵼ��ҳ�����500����
	  blog joke=(blog)session.get(blog.class,topa);  
	  out.println(joke.getContent());	

		out.flush();
		out.close();
		
		

	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	this.doGet(request, response);
	}

	public void init() throws ServletException {
	}

}
