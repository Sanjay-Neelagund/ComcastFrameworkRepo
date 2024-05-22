package practice;

import java.util.Date;

public class timeStamp {
	public static void main(String[] args) {
		String timeStamp=new Date().toString().replace(" ", "_").replace(":", "_");
		System.out.println(timeStamp);
	}

}
