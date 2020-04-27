

import java.io.IOException;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class ApplyJob
 */
public class ApplyJob extends HttpServlet {
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session=request.getSession();
		
		String email=request.getParameter("email");
		System.out.println(email);
		
		String sname=(String) session.getAttribute("sname");
		String tenth=(String) session.getAttribute("tenth");
		String puc=(String) session.getAttribute("puc");
		String engg=(String) session.getAttribute("engg");
		System.out.println(sname+tenth+puc+engg);
		
		final String fromEmail= Credentials.email; //sender's mail id.
		final String pwd=Credentials.pwd;		//sender's mail pwd.
		String toEmail=email;  //reciever's mail id.
		
		String subject="DO NOT REPLY: Mail from Java Program"; // mail subject line
		String msg="Hello HR " + "My name is" + sname+ "," + "I am interested in job" + "my marks in tenth, puc & engineering are" +tenth+ "," +puc+ "," +engg+ "," + "are as follows"; //mail body
		
		//Creating Session Object
		Properties prop = new Properties();
		prop.put("mail.smtp.host",      "smtp.gmail.com");
		prop.put("mail.smtp.port", "587");
		prop.put("mail.smtp.auth", "true");
		prop.put("mail.smtp.starttls.enable", "true");

		Session session1= Session.getDefaultInstance(prop, new javax.mail.Authenticator()
		{
			protected PasswordAuthentication getPasswordAuthentication()
			{
				//sender's mail id and pwd is encapsulated inside "SendersCredentials.java"
				return new PasswordAuthentication(fromEmail, pwd);
			}
		}
		);

		try
		{
		//Composing the Mail
		MimeMessage mesg = new MimeMessage(session1);
		mesg.setFrom(new InternetAddress(fromEmail));
		mesg.addRecipient(Message.RecipientType.TO,new InternetAddress(toEmail));
		mesg.setSubject(subject);  
		mesg.setText(msg);  
		
		//Sending the Mail
		Transport.send(mesg);
		System.out.println("Mail Sent!!");
		response.sendRedirect("/Application/Ajsuccess.html");
		}
		catch(Exception e)
		{
			e.printStackTrace();
	    }
	}

}