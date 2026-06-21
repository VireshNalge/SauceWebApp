package genericUtility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

public class PropertiesFileUtility {
	
	public String toReadDataFromPropertiesFiles(String key) throws Throwable {
		
		 FileInputStream fis = new FileInputStream("./src/test/resources/Commondata.properties");
	     Properties prop = new Properties();
	     prop.load(fis);
	     String value =prop.getProperty(key);
	     return value;
	}

}
