package com.component.blog;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import page_flip.User;
import page_flip.UserDao;

/**
 * @author Doctor_
 * 2017-3-11  	下午11:48:54
 */
//描述：第一部分，跳转到首页都由这个类全权负责！都是经过这个servlet后才会到达首页；HERE-to-HomePage.java
//功能：起到跳到首页之前先查找数据库的功能，把数据找好后跳到首页即可显示。

public class HomePage extends HttpServlet {

	private static final long serialVersionUID = 1L;


	public HomePage() {
		super();
	}

	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}


	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setCharacterEncoding("utf-8");
		int pageNo = 1;//默认为显示第一页
		UserDao userdao=new UserDao();
		List<User> lists=new ArrayList<User>();
		String pageno=request.getParameter("pageNos");
		//who sends pageNos to this servlet??? the jsp。And what servlet need only is pageNos from jsp.
		if(pageno != null){
		pageNo=Integer.parseInt(pageno);
		}
		lists=userdao.listUser(pageNo);
//		int recordCount=userdao.getPage();//recordCount here represents the totel pages.
		//这下面都是要给MyJsp获取的
		request.setAttribute("recordCount", userdao.getPage());//total pages
		request.setAttribute("listss", lists);//the data lists i want
		request.setAttribute("pageNos", pageNo);//the ith page
		
		request.getRequestDispatcher("/index.jsp").forward(request, response);

	}


	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);
	}


	public void init() throws ServletException {
		// Put your code here
	}

}
