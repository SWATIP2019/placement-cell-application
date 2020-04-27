

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class JobDetails
 */
public class JobDetails extends HttpServlet {
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		 String cname=request.getParameter("cname");
		    String cemail=request.getParameter("cemail");
			String role=request.getParameter("role");
			
			String jtenth=request.getParameter("jtenth");
			String jpuc=request.getParameter("jpuc");
			String jengg=request.getParameter("jengg");
			String sal=request.getParameter("sal");
			String jskills=request.getParameter("jskills");
			String loc=request.getParameter("loc");
			
			Model m=new Model();
			m.setCname(cname);
		    m.setCemail(cemail);
			m.setRole(role);
			m.setJtenth(jtenth);
			m.setJpuc(jpuc);
			m.setJengg(jengg);
			m.setSal(sal);
			m.setJskills(jskills);
			m.setLoc(loc);
			
			int x=m.updateJobDetails();
			if(x==1)
			{
				String cname1=m.getCname();
				HttpSession session=request.getSession(true);
						session.setAttribute("cname",cname1);
				response.sendRedirect("/Application/successJobUpdate.jsp");
			}
			else
			{
				response.sendRedirect("Application/failJobUpdate.html");
				
			}
	}
	

}
