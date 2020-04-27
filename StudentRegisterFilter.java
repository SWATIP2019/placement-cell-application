

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet Filter implementation class StudentRegisterFilter
 */
public class StudentRegisterFilter implements Filter {

    /**
     * Default constructor. 
     */
    public StudentRegisterFilter() {
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
		String sname=request.getParameter("sname");
		
		String age=request.getParameter("age");
		String email=request.getParameter("email");
		String tenth=request.getParameter("tenth");
		String puc=request.getParameter("puc");
		String engg=request.getParameter("engg");
		String skills=request.getParameter("skills");
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		String cpassword=request.getParameter("cpassword");
		if(sname.length()!=0 &&age.length()!=0&&email.length()!=0 && tenth.length()!=0 && puc.length()!=0 && engg.length()!=0 && skills.length()!=0 && username.length()!=0&&password.length()!=0&&cpassword.length()!=0)
      {
			if(password.equals(cpassword)) {
				chain.doFilter(request, response);
			}
				
		}
		else {
			((HttpServletResponse)response).sendRedirect("/Application/errorStudentLogin.html/");
		}
		
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
