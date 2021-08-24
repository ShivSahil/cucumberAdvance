package utils;


public class Constant {

	// such that no one can change these values, I am making them "final" 
	public final static String CONFIG_PROPERTIES_DIRECTORY = 
			System.getProperty("user.dir") + "\\src\\main\\java\\properties\\config.properties";
	
	public final static String GECKO_DRIVER_DIRECTORY = 
			System.getProperty("user.dir") + "\\src\\test\\java\\resources\\other\\geckodriver.exe";
	
	public final static String CHROME_DRIVER_DIRECTORY = 
			System.getProperty("user.dir") + "\\src\\test\\java\\resources\\other\\chromedriver.exe";
	
	

}

