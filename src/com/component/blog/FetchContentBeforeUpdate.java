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
 * 2017-3-7  	����2:20:02
 */
//���������Ǵӵڶ����'��������'�еĵ�� �޸� ���Ӻ���ת������ִ���߼�����ת���༭���޸ģ�all_blogs.jsp-to-HERE-to-update.jsp
//���ܣ������ݿ��ж�ȡ���ͱ��������ʹ�ÿ����ڱ༭������ʾ�Թ��޸ġ�
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
			
			String topage=request.getParameter("toPage");//topage��һ���ַ������������ӵ����
			int topa = Integer.valueOf(topage).intValue();
			//int topa=(Integer)parsetoInteger(topage);//��������⣡�����ᵼ��ҳ�����500����
			blog blog=(blog)session.get(blog.class,topa);
			String title=blog.getTitle();
			String content=blog.getContent();
			//deliever the var to the jsp file
			request.setAttribute("blog_title",title);//ע����jsp�е��õ��ǵ�һ���������ɡ�
			request.setAttribute("blog_content",content);
			request.setAttribute("blog_id",blog.getId());//blog_id represents a integer
			//�����༭��
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
