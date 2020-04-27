

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class StudentRegister
 */
public class StudentRegister extends HttpServlet {

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
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

		System.out.println("In servlet"+sname+age+email+tenth+puc+engg+skills+username+password);

		Model m=new Model();
		m.setSname(sname);
		m.setAge(age);
		m.setEmail(email);
		m.setTenth(tenth);
		m.setPuc(puc);
		m.setEngg(engg);
		m.setSkills(skills);
		m.setUsername(username);
		m.setPassword(password);



		int x=m.register();
		if(x==1)
		{
			response.sendRedirect("/Application/regStudentLogin.html");
		}
		else
		{
			response.sendRedirect("/Application/failLoginRegister.html");

		}


	}

}
