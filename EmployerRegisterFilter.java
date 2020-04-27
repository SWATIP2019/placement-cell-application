

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet Filter implementation class EmployerRegisterFilter
 */
public class EmployerRegisterFilter implements Filter {

    /**
     * Default constructor. 
     */
    public EmployerRegisterFilter() {
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
String ename=request.getParameter("ename");
		
		
		String eemail=request.getParameter("eemail");
		
		String eusername=request.getParameter("eusername");
		String epassword=request.getParameter("epassword");
		String cpassword=request.getParameter("cpassword");
		
		
		if(ename.length()!=0&&eemail.length()!=0 && eusername.length()!=0&&epassword.length()!=0&&cpassword.length()!=0)
	      {
				if(epassword.equals(cpassword)) {
					chain.doFilter(request, response);
				}
					
			}
			else {
				((HttpServletResponse)response).sendRedirect("/Application/errorEmpLogin.html/");
			}
			
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
