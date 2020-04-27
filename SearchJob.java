

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class SearchJob
 */
public class SearchJob extends HttpServlet {
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		HttpSession session=request.getSession();
		String tenth=(String) session.getAttribute("tenth");
		String puc=(String) session.getAttribute("puc");
		String engg=(String) session.getAttribute("engg");
		
		PrintWriter out=response.getWriter();
		System.out.println(tenth+puc+engg); // i am not getting the values from the session
		
		Model m=new Model();
		m.setTenth(tenth);
		m.setPuc(puc);
		m.setEngg(engg);
		
		m.searchJob();
	    
	    ArrayList l = m.l;
	    Iterator itr  = l.iterator();
	    if(itr.hasNext()==true)
	    {
	    	while(itr.hasNext()==true)
		    {
	    	
	    	out.println(itr.next());
	    	
		    }
	    	String htmlres="<html>"
        			+"<body>"
        			+"<h1>"
        			+"<click here to apply job>"
                    +"</h1>"
        			+"<table>"
                    +"<tr>"
        			+"<td> Click here to <a href='/Application/applyJob.html'>apply</a>for job</td>"
        			+"<tr>"
                    +"</table>"
                    +"</body>"
        			+"</html>";
        	response.setContentType("text/html");
        	out = response.getWriter(); 
        	out.println(htmlres);
	    }
	    else
	    {
	    	out.println("Error");
	    }
	    
		}
   
}
