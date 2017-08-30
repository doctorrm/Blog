package useless;
////这个类不用啦！！！！被MyJsp.jsp取代啦！！！解耦合！！！！！！！！！！！！！！！！！！
////这个类不用啦！！！！被MyJsp.jsp取代啦！！！
////这个类不用啦！！！！被MyJsp.jsp取代啦！！！
////这个类不用啦！！！！被MyJsp.jsp取代啦！！！
////这个类不用啦！！！！被MyJsp.jsp取代啦！！！
////这个类不用啦！！！！被MyJsp.jsp取代啦！！！
////这个类不用啦！！！！被MyJsp.jsp取代啦！！！
////这个类不用啦！！！！被MyJsp.jsp取代啦！！！
////这个类不用啦！！！！被MyJsp.jsp取代啦！！！
////这个类不用啦！！！！被MyJsp.jsp取代啦！！！
////这个类不用啦！！！！被MyJsp.jsp取代啦！！！
////这个类不用啦！！！！被MyJsp.jsp取代啦！！！
////这个类不用啦！！！！被MyJsp.jsp取代啦！！！
////这个类不用啦！！！！被MyJsp.jsp取代啦！！！
////这个类不用啦！！！！被MyJsp.jsp取代啦！！！
////这个类不用啦！！！！被MyJsp.jsp取代啦！！！
////这个类不用啦！！！！被MyJsp.jsp取代啦！！！
////这个类不用啦！！！！被MyJsp.jsp取代啦！！！
////这个类不用啦！！！！被MyJsp.jsp取代啦！！！
////这个类不用啦！！！！被MyJsp.jsp取代啦！！！
////这个类不用啦！！！！被MyJsp.jsp取代啦！！！
////这个类不用啦！！！！被MyJsp.jsp取代啦！！！
////这个类不用啦！！！！被MyJsp.jsp取代啦！！！
////这个类不用啦！！！！被MyJsp.jsp取代啦！！！
////这个类不用啦！！！！被MyJsp.jsp取代啦！！！
////这个类不用啦！！！！被MyJsp.jsp取代啦！！！
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
//		//以下的代码都要放在这个方法里面！否则不可以！使用Query查询
//		SessionFactory sessionFactory=HibernateUtil.getSessionFactory();
//		Session session=sessionFactory.openSession();
//		Query query=session.createQuery("from blog ");//得到的其实是所有的数据，如果id不是连续（即有断的），会跳过。如查到的数据对应id有1，2，6，7，8，9，10，11，35.。。
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
//		out.println("  <HEAD><TITLE>所有博文</TITLE></HEAD>");
//		out.println("  <BODY>");
////想做的事在servlet中引入一个jsp文件，以在servlet界面中使用到boostrap。
//		out.println("<h1 align=center><b>下面是所有的博文(含修改，删除，这个页面属于后台)</b></h1>");//set(null)应该为删除，
//		//the following are the links of all the titles
//		while(iterator.hasNext()){//如何倒序遍历，以实现后添加的先显示？？？？？？？？？？？
//			blog joke=(blog)iterator.next();//一定要有这个，否则出现一堆的null使环境崩溃。
//			ida=joke.getId();
//			show_title=joke.getTitle();
//			out.println("<table border=2><tr>");
//			out.println("<td style=width:500px><a href=/Blog/servlet/jump_from_show_all_blogs?toPage="+ida+"><font size=6><b>·</b>"+show_title+"</font></a></td>");
//			//向超链接中传入参数toPage及其值ida,这样每个链接都有不同的ida值。这个类关键就是ida，求到了就好办了
//			//这个是后台的界面，所以如果你要装饰的话得装饰超链接，而且就在这个方法中装饰！
//			
//			//下面是代表删除的超链接
//			out.println("<td><a href=/Blog/servlet/test_delete?toPage="+ida+"><font size=6>"+"删除"+"</font></a></td>");
//			//下面是代表更新的超链接
//			out.println("<td><a href=/Blog/servlet/update?toPage="+ida+"><font size=6>"+"修改"+"</font></a></td>");
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
