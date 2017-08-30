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
 * 2017-3-11  	����11:48:54
 */
//��������һ���֣���ת����ҳ���������ȫȨ���𣡶��Ǿ������servlet��Żᵽ����ҳ��HERE-to-HomePage.java
//���ܣ���������ҳ֮ǰ�Ȳ������ݿ�Ĺ��ܣ��������Һú�������ҳ������ʾ��

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
		int pageNo = 1;//Ĭ��Ϊ��ʾ��һҳ
		UserDao userdao=new UserDao();
		List<User> lists=new ArrayList<User>();
		String pageno=request.getParameter("pageNos");
		//who sends pageNos to this servlet??? the jsp��And what servlet need only is pageNos from jsp.
		if(pageno != null){
		pageNo=Integer.parseInt(pageno);
		}
		lists=userdao.listUser(pageNo);
//		int recordCount=userdao.getPage();//recordCount here represents the totel pages.
		//�����涼��Ҫ��MyJsp��ȡ��
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
