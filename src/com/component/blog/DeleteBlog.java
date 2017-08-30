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
 * 2017-3-7  	����12:37:49
 */
//�������ڡ��������¡������ɾ�����Ӻ���ת���������ɾ���߼���ִ�У�Ȼ�󷵻ص���ҳ��all_blogs��ɾ������-to-HERE-to-HomePage.java
//���ܣ�����ɾ�����ݿ���ָ�����͵Ĺ���
public class DeleteBlog extends HttpServlet {
private static final long serialVersionUID = 1L;

	//ɾ��ָ����¼��������ҳ
	public DeleteBlog() {
		super();
	}

	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}


	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		SessionFactory sessionFactory=HibernateUtil.getSessionFactory();
		Session session=sessionFactory.openSession();
		Transaction transaction=session.beginTransaction();

		
		response.setContentType("text/html;charset=utf-8");
		
		 String topage=request.getParameter("toPage");//topage��һ���ַ������������ӵ����
		  int topa = Integer.valueOf(topage).intValue();
		//int topa=(Integer)parsetoInteger(topage);//��������⣡�����ᵼ��ҳ�����500����
		  blog blog=(blog)session.get(blog.class,topa);
		session.delete(blog);
		//session.save(blog);//��һ�о��Բ��ܼӣ���Ϊ����Ǳ���blog����������ɾ���������������ְѱ�ɾ�ı��浽���ݿ�ĩβ������
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
