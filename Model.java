import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import oracle.jdbc.driver.OracleDriver;

public class Model {
	 Connection con;
	 ArrayList l=new ArrayList();
	 PreparedStatement pstmt;
	ResultSet rs;
	private String sname;
	private String age;
	private String email;
	private String tenth;
	private String puc;
	private String engg;
	private String skills;
	private String username;
	private String password;
	
	
	private String ename;
	private String eemail;
	private String eusername;
	private String epassword;
	
	private String cname;
	private String cemail;
	private String role;
	private String jtenth;
	private String jpuc;
	private String jengg;
	private String sal;
	private String jskills;
	
	
	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getSal() {
		return sal;
	}

	public void setSal(String sal) {
		this.sal = sal;
	}

	public String getLoc() {
		return loc;
	}

	public void setLoc(String loc) {
		this.loc = loc;
	}

	private String loc;
	
	
	public String getCname() {
		return cname;
	}

	public void setCname(String cname) {
		this.cname = cname;
	}

	public String getCemail() {
		return cemail;
	}

	public void setCemail(String cemail) {
		this.cemail = cemail;
	}

	public String getJtenth() {
		return jtenth;
	}

	public void setJtenth(String jtenth) {
		this.jtenth = jtenth;
	}

	public String getJpuc() {
		return jpuc;
	}

	public void setJpuc(String jpuc) {
		this.jpuc = jpuc;
	}

	public String getJengg() {
		return jengg;
	}

	public void setJengg(String jengg) {
		this.jengg = jengg;
	}

	
	public String getJskills() {
		return jskills;
	}

	public void setJskills(String jskills) {
		this.jskills = jskills;
	}

	
	
	
	
	public String getEname() {
		return ename;
	}

	public void setEname(String ename) {
		this.ename = ename;
	}

	public String getEemail() {
		return eemail;
	}

	public void setEemail(String eemail) {
		this.eemail = eemail;
	}

	public String getEusername() {
		return eusername;
	}

	public void setEusername(String eusername) {
		this.eusername = eusername;
	}

	public String getEpassword() {
		return epassword;
	}

	public void setEpassword(String epassword) {
		this.epassword = epassword;
	}
	
	
	
	public Model()
	{
		try {
			DriverManager.deregisterDriver(new OracleDriver());
			con=DriverManager.getConnection("jdbc:oracle:thin://@localhost:1522/XE","system","system");
		}
		catch(Exception e){
			e.printStackTrace();
			
		}
	}
	
	public Connection getCon() {
		return con;
	}
	public void setCon(Connection con) {
		this.con = con;
	}
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTenth() {
		return tenth;
	}
	public void setTenth(String tenth) {
		this.tenth = tenth;
	}
	public String getPuc() {
		return puc;
	}
	public void setPuc(String puc) {
		this.puc = puc;
	}
	public String getEngg() {
		return engg;
	}
	public void setEngg(String engg) {
		this.engg = engg;
	}
	public String getSkills() {
		return skills;
	}
	public void setSkills(String skills) {
		this.skills = skills;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		System.out.println("password"+password);
		this.password = password;
	}
	public PreparedStatement getPstmt() {
		return pstmt;
	}
	public void setPstmt(PreparedStatement pstmt) {
		this.pstmt = pstmt;
	}
	
	
	int register()
	{
		try {
			
		String s="INSERT INTO APPLICANT VALUES(?,?,?,?,?,?,?,?,?)";
		pstmt=con.prepareStatement(s);
		pstmt.setString(1, sname);
		pstmt.setString(2, email);
		pstmt.setString(3, tenth);
		pstmt.setString(4, puc);
		pstmt.setString(5, engg);
		pstmt.setString(6, skills);
		pstmt.setString(7, username);
		pstmt.setString(8, password);
		pstmt.setString(9, age);
		
		
	
		
		
		int x=pstmt.executeUpdate();
		return x;
		
		}
		catch(Exception e){
			e.printStackTrace();
			
		}
		return 0;
	}
	int login()
	{
		try {
		String s="Select * from APPLICANT WHERE username=? and password=?";
		pstmt=con.prepareStatement(s);
		pstmt.setString(1, username);
		pstmt.setString(2, password);
		rs=pstmt.executeQuery();
		if(rs.next()==true)
		{
		     sname=rs.getString("sname");
		     age=rs.getString("age");
		     email=rs.getString("email");
		     tenth=rs.getString("tenth");
		     puc=rs.getString("puc");
		     engg=rs.getString("engg");
		     skills=rs.getString("skills");
		     username=rs.getString("username");
		     password=rs.getString("password");
		     
			// need to get all attributes from database
			
			return 1;
		}
		else
		{
			return 0;
		}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return 0;	
	}
	int empRegister()
	{
		try {
			
		String s="INSERT INTO Employer VALUES(?,?,?,?)";
		pstmt=con.prepareStatement(s);
		pstmt.setString(1, ename);
		pstmt.setString(2, eemail);
		
		pstmt.setString(3, eusername);
		pstmt.setString(4, epassword);
		int x=pstmt.executeUpdate();
		return x;
		
		}
		catch(Exception e){
			e.printStackTrace();
			
		}
		return 0;
	}
	int empLogin()
	{
		try {
		String s="Select * from Employer WHERE eusername=? and epassword=?";
		pstmt=con.prepareStatement(s);
		pstmt.setString(1, eusername);
		pstmt.setString(2, epassword);
		rs=pstmt.executeQuery();
		if(rs.next()==true)
		{
		     ename=rs.getString("ename");
			
			
			return 1;
		}
		else
		{
			return 0;
		}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return 0;	
	}
	
	int updateJobDetails() {
		try {
			
			String s="INSERT INTO JOBS VALUES(?,?,?,?,?,?,?,?,?)";
			pstmt=con.prepareStatement(s);
			pstmt.setString(1, cname);
			pstmt.setString(2, cemail);
			pstmt.setString(3, role);
			pstmt.setString(4, jtenth);
			pstmt.setString(5, jpuc);
			pstmt.setString(6, jengg);
			pstmt.setString(7, sal);
			pstmt.setString(8, jskills);
			pstmt.setString(9, loc);
		
		int x=pstmt.executeUpdate();
			return x;
			
			}
			catch(Exception e){
				e.printStackTrace();
				
			}
			return 0;		
	}
	int forgotPassword()
	{
		try {
			String s="UPDATE EMPLOYER SET EPASSWORD=? WHERE EEMAIL=?";
			pstmt=con.prepareStatement(s);
			pstmt.setString(1, epassword);
			pstmt.setString(2, eemail);
			int x=pstmt.executeUpdate();
			return x;
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return 0;
	}
	
	void searchJob() {
		try {
			String s="Select * from JOBS WHERE Jtenth<=? and Jpuc<=? and Jengg<=?";
			pstmt=con.prepareStatement(s);
			pstmt.setString(1, tenth);
			pstmt.setString(2, puc);
			pstmt.setString(3, engg);
			rs=pstmt.executeQuery();
		while(rs.next()==true)
			{
			cname=rs.getString("cname");
			cemail=rs.getString("cemail");
			role=rs.getString("role");
			jtenth=rs.getString("jtenth");
			jpuc=rs.getString("jpuc");
			jengg=rs.getString("jengg");
			sal=rs.getString("sal");
			jskills=rs.getString("jskills");
			loc=rs.getString("loc");
       l.add(new Job(cname,cemail,role,jtenth,jpuc,jengg,sal,jskills,loc));
			}
			
				
		
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}	
		
		
	}
}
