

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class EmployerRegister
 */
public class EmployerRegister extends HttpServlet {
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String ename=request.getParameter("ename");
		
		String eemail=request.getParameter("eemail");
		
		String eusername=request.getParameter("eusername");
		String epassword=request.getParameter("epassword");
		String cpassword=request.getParameter("cpassword");
		Model m=new Model();
		m.setEname(ename);
		
		m.setEemail(eemail);
		
		m.setEusername(eusername);
		m.setEpassword(epassword);
		
		
		
		int x=m.empRegister();
		if(x==1)
		{
			response.sendRedirect("/Application/regEmpLogin.html");
		}
		else
		{
			response.sendRedirect("/Application/failEmpLoginRegister.html");
			
		}
		
		
	}
}
