package useless;
////����಻��������������MyJsp.jspȡ��������������ϣ�����������������������������������
////����಻��������������MyJsp.jspȡ����������
////����಻��������������MyJsp.jspȡ����������
////����಻��������������MyJsp.jspȡ����������
////����಻��������������MyJsp.jspȡ����������
////����಻��������������MyJsp.jspȡ����������
////����಻��������������MyJsp.jspȡ����������
////����಻��������������MyJsp.jspȡ����������
////����಻��������������MyJsp.jspȡ����������
////����಻��������������MyJsp.jspȡ����������
////����಻��������������MyJsp.jspȡ����������
////����಻��������������MyJsp.jspȡ����������
////����಻��������������MyJsp.jspȡ����������
////����಻��������������MyJsp.jspȡ����������
////����಻��������������MyJsp.jspȡ����������
////����಻��������������MyJsp.jspȡ����������
////����಻��������������MyJsp.jspȡ����������
////����಻��������������MyJsp.jspȡ����������
////����಻��������������MyJsp.jspȡ����������
////����಻��������������MyJsp.jspȡ����������
////����಻��������������MyJsp.jspȡ����������
////����಻��������������MyJsp.jspȡ����������
////����಻��������������MyJsp.jspȡ����������
////����಻��������������MyJsp.jspȡ����������
////����಻��������������MyJsp.jspȡ����������
////����಻��������������MyJsp.jspȡ����������
//package com.picture.yi;
//
//import java.io.IOException;
//import java.io.PrintWriter;
//
//import java.util.Iterator;
//import java.util.List;
//
//import javax.servlet.ServletException;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//import org.hibernate.Criteria;
//import org.hibernate.Query;
//import org.hibernate.Session;
//import org.hibernate.SessionFactory;
//import org.hibernate.criterion.Restrictions;
//
//public class show_all_blogs extends HttpServlet {
//	public static int ida;
//	public static String show_title;
//	private static final long serialVersionUID = 6288617848992667706L;
//
//	public show_all_blogs() {
//		super();
//	}
//
//	public void destroy() {
//		super.destroy(); // Just puts "destroy" string in log
//		// Put your code here
//	}
//
//	public void doGet(HttpServletRequest request, HttpServletResponse response)
//			throws ServletException, IOException {
//		//���µĴ��붼Ҫ��������������棡���򲻿��ԣ�ʹ��Query��ѯ
//		SessionFactory sessionFactory=HibernateUtil.getSessionFactory();
//		Session session=sessionFactory.openSession();
//		Query query=session.createQuery("from blog ");//�õ�����ʵ�����е����ݣ����id�������������жϵģ�������������鵽�����ݶ�Ӧid��1��2��6��7��8��9��10��11��35.����
//		List list=query.list();
//		Iterator iterator=list.iterator();
//		response.setContentType("text/html;charset=utf-8");
//		request.getRequestDispatcher("/common.jsp").include(request,response);				
//
//		PrintWriter out = response.getWriter();
//		out.println("<!DOCTYPE HTML>");
//
//         
//         
//		out.println("<HTML>");
//		out.println("  <HEAD><TITLE>���в���</TITLE></HEAD>");
//		out.println("  <BODY>");
////����������servlet������һ��jsp�ļ�������servlet������ʹ�õ�boostrap��
//		out.println("<h1 align=center><b>���������еĲ���(���޸ģ�ɾ�������ҳ�����ں�̨)</b></h1>");//set(null)Ӧ��Ϊɾ����
//		//the following are the links of all the titles
//		while(iterator.hasNext()){//��ε����������ʵ�ֺ���ӵ�����ʾ����������������������
//			blog joke=(blog)iterator.next();//һ��Ҫ��������������һ�ѵ�nullʹ����������
//			ida=joke.getId();
//			show_title=joke.getTitle();
//			out.println("<table border=2><tr>");
//			out.println("<td style=width:500px><a href=/Blog/servlet/jump_from_show_all_blogs?toPage="+ida+"><font size=6><b>��</b>"+show_title+"</font></a></td>");
//			//�������д������toPage����ֵida,����ÿ�����Ӷ��в�ͬ��idaֵ�������ؼ�����ida�����˾ͺð���
//			//����Ǻ�̨�Ľ��棬���������Ҫװ�εĻ���װ�γ����ӣ����Ҿ������������װ�Σ�
//			
//			//�����Ǵ���ɾ���ĳ�����
//			out.println("<td><a href=/Blog/servlet/test_delete?toPage="+ida+"><font size=6>"+"ɾ��"+"</font></a></td>");
//			//�����Ǵ�����µĳ�����
//			out.println("<td><a href=/Blog/servlet/update?toPage="+ida+"><font size=6>"+"�޸�"+"</font></a></td>");
//			out.println("</tr></table>");
//		}		
//
//		
//		out.println("  </BODY>");
//		out.println("</HTML>");
//		out.flush();
//		out.close();
//		session.close();
//		sessionFactory.close();
//	}
//
//	
//	public void doPost(HttpServletRequest request, HttpServletResponse response)
//			throws ServletException, IOException {
//
//			this.doGet(request,response);
//	}
//
//	
//	public void init() throws ServletException {
//		// Put your code here
//		
//	}
//
//}
