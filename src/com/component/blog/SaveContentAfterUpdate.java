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
 * 2017-3-7  	下午4:11:11
 */
//描述：在编辑区提交后返回首页的中途经过这里以把修改后的内容保存到数据库，update.jsp-to-HERE-to-HomePage.java
//功能：把修改后的博客内容保存到数据库,并覆盖原来的内容。
public class SaveContentAfterUpdate extends HttpServlet {
private static final long serialVersionUID = 1L;

	//修改内容后返回首页

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
		response.setContentType("text/html;charset=utf-8");//编码一定要有
		
		 int override_id= (Integer)request.getSession().getAttribute("override_id");         
		
	    	SessionFactory sessionFactory=HibernateUtil.getSessionFactory();
			Session session=sessionFactory.openSession();
			Transaction transaction=session.beginTransaction();
			blog blog=(blog)session.get(blog.class,override_id);//获取指定的博客
			//获取修改的值
			String title=request.getParameter("title");
			String content=request.getParameter("content");
			//把新的修改的内容保存到数据库
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
