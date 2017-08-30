package com.component.blog;

import java.io.IOException;

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
 * 2017-3-7  	下午2:20:02
 */
//描述：这是从第二板块'所有文章'中的点击 修改 链接后跳转而来，执行逻辑后跳转到编辑区修改；all_blogs.jsp-to-HERE-to-update.jsp
//功能：从数据库中读取博客标题和内容使得可以在编辑区中显示以供修改。
public class FetchContentBeforeUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	public FetchContentBeforeUpdate() {
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
			
			String topage=request.getParameter("toPage");//topage是一个字符串，代表链接的序号
			int topa = Integer.valueOf(topage).intValue();
			//int topa=(Integer)parsetoInteger(topage);//这个有问题！！！会导致页面出现500错误。
			blog blog=(blog)session.get(blog.class,topa);
			String title=blog.getTitle();
			String content=blog.getContent();
			//deliever the var to the jsp file
			request.setAttribute("blog_title",title);//注意在jsp中调用的是第一个参数即可。
			request.setAttribute("blog_content",content);
			request.setAttribute("blog_id",blog.getId());//blog_id represents a integer
			//跳到编辑区
			request.getRequestDispatcher("/update.jsp").forward(request, response);		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
				this.doGet(request, response);
			
	}


	public void init() throws ServletException {
		// Put your code here
	}

}
