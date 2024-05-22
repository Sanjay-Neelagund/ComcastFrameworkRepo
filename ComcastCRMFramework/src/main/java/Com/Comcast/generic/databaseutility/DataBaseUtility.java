package Com.Comcast.generic.databaseutility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class DataBaseUtility {
	Connection conn=null;

	public void getDBConnection(String url,String useName,String password) throws Throwable {
		try {
		Driver driveRef=new Driver();
		DriverManager.registerDriver(driveRef);
		conn=DriverManager.getConnection(url, useName, password);
		}catch (Exception e) {
			
		}
	}
	public void getDBConnection() throws Throwable {
		try {
		Driver driveRef=new Driver();
		DriverManager.registerDriver(driveRef);
		conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","root");
		}catch (Exception e) {
			
		}
	}
	public void closeDBConnection() throws Throwable {
		try {
		conn.close();
		}
		catch (Exception e) {
			
		}
		
	}
	public ResultSet executeSelectQuery(String query) throws Throwable {
		ResultSet res=null;
		try {
	Statement stat=	conn.createStatement();
	   res=stat.executeQuery(query);
		}catch (Exception e) {
			
		}
	return res;
		
	}
	public int executeNonSelectQuery(String query) throws Throwable {
		int result = 0;
		try {
		Statement stat=conn.createStatement();
		 result= stat.executeUpdate(query);
		}
		catch (Exception e) {	
		}
		return result;
	}

}
