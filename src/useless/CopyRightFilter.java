package useless;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;

/**
 * @author Doctor_
 * 2017-3-18  	下午6:00:45
 */
public class CopyRightFilter extends HttpServlet implements Filter {

	private static final long serialVersionUID = 1L;
	protected FilterConfig config;
	protected String date;
	@Override
	public void init(FilterConfig filterconfig) throws ServletException {
			this.config=filterconfig;
			date=filterconfig.getInitParameter("date");
			
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
				chain.doFilter(request, response);
				PrintWriter out=response.getWriter();
				out.println("<br><center><font size=4>版权所有:小白公司</font></center>");
				if(date!=null){
					out.println("<br><center><font size=4>"+date+"</font></center>");
				}
				out.flush();
	}

	public void destroy() {
		 this.config=null;		// Put your code here
		}
	

}
