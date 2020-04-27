
public class OTP {

	int otp() 
	{
		int otp;

		double d=Math.random();

		d=d*1000000;
		otp=(int) d;
		System.out.println(otp);
		return otp;
	}


}
