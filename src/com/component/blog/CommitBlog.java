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
 * 2017-3-5  	下午5:22:00
 */
//描述：这是在撰写博客版块提交后跳转而来，在保存到数据库后再跳到首页。write_blog-to-HERE-to-HomePage.java
//功能：提供保存撰写的博客内容到数据库的功能，并跳到首页。
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
//		String m=(String) request.getAttribute("title");//不能用这个来获取
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");//编码一定要有
		String title=request.getParameter("title");//获取jsp传来的标题数据（用户输入的）
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
