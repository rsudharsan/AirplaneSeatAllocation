package com.asc.util;



import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
 
/**
 * @author Crunchify.com
 * 
 */
 
public class PropertyReader {
	String result = "";
	InputStream inputStream;
	String propFileName;
	
	public PropertyReader(String fileName){
		
		this.propFileName = fileName;
	}
 
	public String getPropValues(String propname) throws IOException {
 
		try {
			Properties prop = new Properties();
			inputStream = getClass().getClassLoader().getResourceAsStream(propFileName);
			if (inputStream != null) {
				prop.load(inputStream);
			} else {
				throw new FileNotFoundException("property file '" + propFileName + "' not found in the classpath");
			}
			result = prop.getProperty(propname);
			
			
		} catch (Exception e) {
			System.out.println("Exception: " + e);
		} finally {
			inputStream.close();
		}
		return result;
	}
}