package com.Configuration;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ConfigFileReader {
	
	public String getReportConfigPath() throws IOException
	{
		FileReader reader=new FileReader("O:/workspace/Cucumber_Maven_TestNG_V2/Config/Configuration.properties");  
		Properties properties=new Properties();  
		properties.load(reader);
		 String reportConfigPath = properties.getProperty("reportConfigPath");
		 if(reportConfigPath!= null) {
			 return reportConfigPath;
		 }else {
			 throw new RuntimeException("Report Config Path not specified in the Configuration.properties file for the Key:reportConfigPath"); 
		 }
	}

}
