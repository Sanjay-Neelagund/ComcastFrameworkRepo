package Com.Comcast.generic.webdriverutility;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

public class JavaUtility {
	Date date=new Date();
	public int getRandomNumber() {
		Random ran =new Random();
		int num=ran.nextInt(5000);
		return num;	
	}
	public String getSystemDateYYYYMMDD() {
		
        SimpleDateFormat sim=new SimpleDateFormat("YYYY-MM-dd");
		String dat=sim.format(date);
		return dat;	
	}
	public String getRequiredDate() {
		SimpleDateFormat sim =new SimpleDateFormat("YYYY-MM-dd");
		sim.format(date);
		Calendar cal= sim.getCalendar();
	     cal.add(Calendar.DAY_OF_MONTH, 30);
	     String endDate=sim.format(cal.getTime());
		return endDate;
	    
	     
	}
	

}
