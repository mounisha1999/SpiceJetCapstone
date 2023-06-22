package utilities;

import java.io.FileInputStream;
import java.util.Properties;

public class FileUtils {

	public String readProperty(String key) {

		String value = null;
		try {
			FileInputStream input = new FileInputStream(
					"D:\\Java_Practise\\SpiceJet\\target\\test-classes\\Config.Properties");
		
			Properties prop = new Properties();
			prop.load(input);
			value = prop.getProperty(key);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return value;

	}

}
