

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class EmpFPR
 */
public class EmpFPR extends HttpServlet {
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String uotp=request.getParameter("uotp");
		System.out.println(uotp);
		
		HttpSession session1=request.getSession();
		String a = (String) session1.getAttribute("otp");
		System.out.println(a);
		
		if(uotp.equals(a))
		{
			response.sendRedirect("/Application/empFPRP.html");
		}
		else {
			response.sendRedirect("/Application/empFP.html");
		}
	}

}
