package by.eprinting.utils;

import java.io.IOException;
import java.util.Properties;

import javax.servlet.ServletContext;

public class PropertiesUtil {
	public static Properties getEmailProperties(ServletContext context) {
		Properties properties = new Properties();
		
		try {
			properties.load(context.getResourceAsStream("/WEB-INF/resources/email.properties"));
		
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return properties;
	}
}
