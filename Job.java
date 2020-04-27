
public class Job {
	
	String cname;
	String cemail;
	String role;
	String jtenth;
	String jpuc;
	String jengg;
	String sal;
	String jskills;
	String loc;
public	Job(String cname,String cemail,String role,String jtenth,String jpuc,String jengg,String sal,String jskills,String loc)
	{
		this.cname=cname;
		this.cemail=cemail;
		this.role=role;
		this.jtenth=jtenth;
		this.jpuc=jpuc;
		this.jengg=jengg;
		this.sal=sal;
		this.jskills=jskills;
		this.loc=loc;
		
	}

public String toString()
{
	System.out.println("in Model"+cname+" "+cemail+" "+role+" "+jtenth  +" "+jpuc+" "+jengg +"  "+sal+"   "+jskills+"  "+loc);
	return cname+" "+cemail+" "+role+" "+jtenth  +" "+jpuc+" "+jengg +"  "+sal+"   "+jskills+"  "+loc;
	
}


}

