package loggingDemo;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

public class LoggingInJava {
	
	private static Logger lg = LogManager.getLogger(LoggingInJava.class);
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		lg.debug("found  a bug");
		lg.error("found error");
		lg.info("info....");

	}

}

//only error msg is printed because we are using the default configuration of logger
// to change appenders(place where logs are present ) or root we need to create the xml/properties file 

 
// delete the module file as it is deprecated
