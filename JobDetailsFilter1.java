

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet Filter implementation class JobDetailsFilter1
 */
public class JobDetailsFilter1 implements Filter {

    /**
     * Default constructor. 
     */
    public JobDetailsFilter1() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		// place your code here

		// pass the request along the filter chain
        String cname=request.getParameter("cname");
	    String cemail=request.getParameter("cemail");
		String role=request.getParameter("role");
		
		String jtenth=request.getParameter("jtenth");
		String jpuc=request.getParameter("jpuc");
		String jengg=request.getParameter("jengg");
		String sal=request.getParameter("sal");
		String jskills=request.getParameter("jskills");
		String loc=request.getParameter("loc");
		if(cname.length()!=0 &&cemail.length()!=0 &&role.length()!=0 &&jtenth.length()!=0 &&jpuc.length()!=0 &&jengg.length()!=0 &&sal.length()!=0 &&jskills.length()!=0 &&loc.length()!=0)
		{
			chain.doFilter(request, response);
		}
		else {
			((HttpServletResponse)response).sendRedirect("/Application/errorJobDetails.html/");
		}
			
		
		
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
