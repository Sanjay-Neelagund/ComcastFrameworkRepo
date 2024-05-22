package Com.Comcast.generic.fileutility;

import java.io.FileNotFoundException;
import java.io.FileReader;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class Jsonutility {
	public String getDataFromJsonFile(String key) throws Throwable {
		FileReader file=new FileReader("./src/main/resources/CommonData.json");
		JSONParser json=new JSONParser();
		Object obj=json.parse(file);
		JSONObject jobj=(JSONObject) obj;
		String data=(String) jobj.get(key);
		return data;
	}

}
