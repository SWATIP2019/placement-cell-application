

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class EmpFPRP
 */
public class EmpFPRP extends HttpServlet {
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			// TODO Auto-generated method stub
		HttpSession session1=request.getSession(true);
		String eemail=(String) session1.getAttribute("eemail");
		String epwd=request.getParameter("epwd");
		Model m=new Model();
		m.setEemail(eemail);
		m.setEpassword(epwd);
		int x=m.forgotPassword();
		session1.invalidate();
		if(x==1)
		{
			response.sendRedirect("/Application/successfullyPasswordReset.html");	
		}
		else {
			response.sendRedirect("/Application/failureInPasswordReset.html");
		}
		}
	
}
