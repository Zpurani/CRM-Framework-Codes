package base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


import utilites.TestUtil;

public class TestBase {
	
	public static WebDriver driver;
	public static Properties prop;
	
	
	
	
	public TestBase (){
		
		try {
			prop = new Properties();
			FileInputStream ip = new FileInputStream("/Users/zankhanapurani/Desktop/Class/Seleneium_Workspace/PageObjectModelCRM/src/main/java/config/config.properties");
			prop.load(ip);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public static void initialization () {
		String browserName = prop.getProperty("browser");
		if(browserName.equals("firefox")) {
			System.setProperty("webdriver.gecko.driver","/Users/zankhanapurani/Desktop/Class/SeleniumJars/geckodriver");
			driver = new FirefoxDriver();		
		}else {
			System.setProperty("webdriver.chrome.driver","/Users/zankhanapurani/Desktop/Class/SeleniumJars/chromedriver");
	        driver = new ChromeDriver();
		
		}
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		
		driver.get(prop.getProperty("url"));

	
	}
	
}
