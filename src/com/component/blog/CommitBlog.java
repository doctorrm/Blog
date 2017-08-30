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
 * 2017-3-5  	����5:22:00
 */
//������������׫д���Ͱ���ύ����ת�������ڱ��浽���ݿ����������ҳ��write_blog-to-HERE-to-HomePage.java
//���ܣ��ṩ����׫д�Ĳ������ݵ����ݿ�Ĺ��ܣ���������ҳ��
public class CommitBlog extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public CommitBlog() {
		super();
	}

	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
//		String m=(String) request.getAttribute("title");//�������������ȡ
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");//����һ��Ҫ��
		String title=request.getParameter("title");//��ȡjsp�����ı������ݣ��û�����ģ�
		String content=request.getParameter("content");
		blog joke=new blog();		
		joke.setContent(content);
		joke.setTitle(title);
		SessionFactory sessionFactory=HibernateUtil.getSessionFactory();
		Session session=sessionFactory.openSession();
		Transaction transaction=session.beginTransaction();
		session.save(joke);
		transaction.commit();
		session.close();	
		request.getRequestDispatcher("/servlet/HomePage").forward(request, response);
	}


	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doGet(request, response);
	}

	public void init() throws ServletException {
		// Put your code here
	}
}
