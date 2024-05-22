package Com.Comcast.generic.fileutility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

public class FileUtility {
	public String getDataFromPropertyFile(String key) throws Throwable {
		FileInputStream fis=new  FileInputStream("./src/main/resources/commonData.properties");
		Properties pobj=new Properties();
		pobj.load(fis);
		String data=pobj.getProperty(key);
		return data;
	}

}
