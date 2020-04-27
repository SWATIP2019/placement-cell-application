    import java.io.IOException;
	import java.util.Properties;
    import java.util.Scanner;

    import javax.mail.Message;
	import javax.mail.MessagingException;
	import javax.mail.PasswordAuthentication;
	import javax.mail.Session;
	import javax.mail.Transport;
	import javax.mail.internet.AddressException;
	import javax.mail.internet.InternetAddress;
	import javax.mail.internet.MimeMessage;
	
public class SendMail {

		public static void main(String[] args) {
			System.out.println("Enter an Email address");
			Scanner scan = new Scanner(System.in);
			String email = scan.nextLine();
			OTP o=new OTP();
			int otp=o.otp();
			
			final String fromEmail= Credentials.email; //sender's mail id.
			final String pwd=Credentials.pwd;		//sender's mail pwd.
			String toEmail=email;  //reciever's mail id.
			
			String subject="DO NOT REPLY: Mail from Java Program"; // mail subject line
			String msg="Hi"+email+" , I have sent this mail using java program."+otp; //mail body
			
			//Creating Session Object
			Properties prop = new Properties();
			prop.put("mail.smtp.host","smtp.gmail.com");
			prop.put("mail.smtp.port", "587");
			prop.put("mail.smtp.auth", "true");
			prop.put("mail.smtp.starttls.enable", "true");

			Session session = Session.getDefaultInstance(prop, new javax.mail.Authenticator()
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
			MimeMessage mesg = new MimeMessage(session);
			mesg.setFrom(new InternetAddress(fromEmail));
			mesg.addRecipient(Message.RecipientType.TO,new InternetAddress(toEmail));
			mesg.setSubject(subject);  
			mesg.setText(msg);  
			
			//Sending the Mail
			Transport.send(mesg);
			System.out.println("Mail Sent!!");
			}
			catch(Exception e)
			{
				e.printStackTrace();
		    }
	}

	}
