package com.component.blog;
import java.text.SimpleDateFormat;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.query.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import po.HibernateUtil;
import po.comment;

/**
 * @author Doctor_
 * 2017-3-17  	上午12:03:54
 */
//描述：在留言版块中点击提交后跳转而来，执行保存逻辑后再跳回到留言版块。comment.jsp-to-HERE-comment.jsp
//功能：保存留言到数据库并读取，使得返回到留言界面后会显示用户刚刚发表的留言。
public class CommentLogic extends HttpServlet {

	private static final long serialVersionUID = 1L;


	public CommentLogic() {
		super();
	}

	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	@SuppressWarnings("unchecked")
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		String user=request.getParameter("user");
		String content=request.getParameter("content");//获取用户输入的数据

		SessionFactory sessionFactory=HibernateUtil.getSessionFactory();
		Session session=sessionFactory.openSession();
		Transaction transaction=session.beginTransaction();
		comment comment=new comment();

		SimpleDateFormat sdf1=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date=new Date();
		String time=sdf1.format(date);
		
	
		
		//只有用户名和内容都不为空时才会提交给数据库，格式要记好。
		if(user!=null&&!user.trim().equals("")){
			if(content!=null&&!content.trim().equals("")){
		comment.setContent(content);
		comment.setUser(user);
		comment.setTime(time);
		session.save(comment);
			}
		}
		
		List<comment> list=new ArrayList<comment>();
		Query query=session.createQuery("from comment");//不知道跟包位置有没有关系
		list=query.list();
		transaction.commit();
		session.close();
		
		request.setAttribute("list", list);
		request.getRequestDispatcher("/comment.jsp").forward(request, response);
		
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
this.doGet(request, response);
	}

	
	public void init() throws ServletException {
		// Put your code here
	}

}
