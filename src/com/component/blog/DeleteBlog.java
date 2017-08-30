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
 * 2017-3-7  	下午12:37:49
 */
//描述：在‘所有文章’版块点击删除链接后跳转到这里进行删除逻辑的执行，然后返回到首页。all_blogs的删除链接-to-HERE-to-HomePage.java
//功能：起到了删除数据库中指定博客的功能
public class DeleteBlog extends HttpServlet {
private static final long serialVersionUID = 1L;

	//删除指定纪录并返回首页
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
		
		 String topage=request.getParameter("toPage");//topage是一个字符串，代表链接的序号
		  int topa = Integer.valueOf(topage).intValue();
		//int topa=(Integer)parsetoInteger(topage);//这个有问题！！！会导致页面出现500错误。
		  blog blog=(blog)session.get(blog.class,topa);
		session.delete(blog);
		//session.save(blog);//这一行绝对不能加，因为这个是保存blog对象，上面是删除操作，这行是又把被删的保存到数据库末尾。。。
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
