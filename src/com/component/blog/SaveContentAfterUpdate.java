package com.component.blog;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import po.HibernateUtil;
import po.blog;

/**
 * @author Doctor_
 * 2017-3-7  	����4:11:11
 */
//�������ڱ༭���ύ�󷵻���ҳ����;���������԰��޸ĺ�����ݱ��浽���ݿ⣬update.jsp-to-HERE-to-HomePage.java
//���ܣ����޸ĺ�Ĳ������ݱ��浽���ݿ�,������ԭ�������ݡ�
public class SaveContentAfterUpdate extends HttpServlet {
private static final long serialVersionUID = 1L;

	//�޸����ݺ󷵻���ҳ

	public SaveContentAfterUpdate() {
		super();
	}

	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");//����һ��Ҫ��
		
		 int override_id= (Integer)request.getSession().getAttribute("override_id");         
		
	    	SessionFactory sessionFactory=HibernateUtil.getSessionFactory();
			Session session=sessionFactory.openSession();
			Transaction transaction=session.beginTransaction();
			blog blog=(blog)session.get(blog.class,override_id);//��ȡָ���Ĳ���
			//��ȡ�޸ĵ�ֵ
			String title=request.getParameter("title");
			String content=request.getParameter("content");
			//���µ��޸ĵ����ݱ��浽���ݿ�
			blog.setTitle(title);
			blog.setContent(content);
			session.close();
			transaction.commit();
			request.getRequestDispatcher("/servlet/HomePage").forward(request, response);
			
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
				doGet(request,response);
	}

	public void init() throws ServletException {
		// Put your code here
	}

}
