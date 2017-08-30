package page_flip;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import page_flip.User;
import page_flip.UserDao;
public class ListUser extends HttpServlet {
private static final long serialVersionUID = 1L;
  public ListUser() {
	  super();
}
  public void destroy() {
	super.destroy(); // Just puts "destroy" string in log
// Put your code here
}
  public void doGet(HttpServletRequest request, HttpServletResponse response)
   throws ServletException, IOException {
	  	doPost(request, response);
}
 public void doPost(HttpServletRequest request, HttpServletResponse response)
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
//			int recordCount=userdao.getPage();//recordCount here represents the totel pages.
			//这下面都是要给MyJsp获取的
			request.setAttribute("recordCount", userdao.getPage());//total pages
			request.setAttribute("listss", lists);//the data lists i want
			request.setAttribute("pageNos", pageNo);//the ith page
			request.getRequestDispatcher("/all_blogs.jsp").forward(request, response);
}
public void init() throws ServletException {
// Put your code here
	}
}
