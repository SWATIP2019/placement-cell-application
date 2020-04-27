

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class EmployerLogin
 */
public class EmployerLogin extends HttpServlet {
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			// TODO Auto-generated method stub
		
	
	String eusername=request.getParameter("eusername");
	String epassword=request.getParameter("epassword");
	Model m=new Model();
	m.setEusername(eusername);
	m.setEpassword(epassword);
	
	int x=m.empLogin();
	
	if(x==1)
	{
		String ename=m.getEname();
		HttpSession session=request.getSession(true);
				session.setAttribute("ename",ename);
				
				
						
						String eemail=m.getEemail();
						
								session.setAttribute("eemail",eemail);
								
								
												                 String eusername1=m.getEusername();
																
												                    session.setAttribute("eusername",eusername1);
												                    
												                    String epassword1=m.getEpassword();
																	
												                        session.setAttribute("epassword",epassword1);
												                       
												                       
						response.sendRedirect("/Application/empHome.jsp");
	}
	else {
		response.sendRedirect("/Application/failedEmpLogin.html");
	}

}
}
