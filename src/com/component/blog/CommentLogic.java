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
 * 2017-3-17  	����12:03:54
 */
//�����������԰���е���ύ����ת������ִ�б����߼��������ص����԰�顣comment.jsp-to-HERE-comment.jsp
//���ܣ��������Ե����ݿⲢ��ȡ��ʹ�÷��ص����Խ�������ʾ�û��ոշ�������ԡ�
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
		String content=request.getParameter("content");//��ȡ�û����������

		SessionFactory sessionFactory=HibernateUtil.getSessionFactory();
		Session session=sessionFactory.openSession();
		Transaction transaction=session.beginTransaction();
		comment comment=new comment();

		SimpleDateFormat sdf1=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date=new Date();
		String time=sdf1.format(date);
		
	
		
		//ֻ���û��������ݶ���Ϊ��ʱ�Ż��ύ�����ݿ⣬��ʽҪ�Ǻá�
		if(user!=null&&!user.trim().equals("")){
			if(content!=null&&!content.trim().equals("")){
		comment.setContent(content);
		comment.setUser(user);
		comment.setTime(time);
		session.save(comment);
			}
		}
		
		List<comment> list=new ArrayList<comment>();
		Query query=session.createQuery("from comment");//��֪������λ����û�й�ϵ
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
