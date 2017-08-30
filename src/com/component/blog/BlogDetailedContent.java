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
 * 2017-3-5  	下午10:16:44
 */
//描述：这个类是在'首页'和'所有文章'中点击博文链接后跳转到这来显示博文详细内容的，这个servlet充当一个界面，index.jsp的博文链接-to-HERE
//功能：显示博文的详细内容
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
		//获取代表颜色栏代号的int
		String id=request.getParameter("id");
		 int int_id = Integer.valueOf(id).intValue();
		request.setAttribute("int_id",int_id);//发给jsp代表颜色标号
		
		//以下的代码都要放在这个方法里面！否则不可以！
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
	  String topage=request.getParameter("toPage");//topage是一个字符串，代表链接的序号
	  int topa = Integer.valueOf(topage).intValue();
	  //int topa=(Integer)parsetoInteger(topage);//这个有问题！！！会导致页面出现500错误。
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
