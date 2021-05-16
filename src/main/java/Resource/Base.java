package Resource;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.core.util.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;
import org.apache.commons.io.*;

public class Base {
	public WebDriver driver;
	

	public WebDriver InitializedDriver() throws IOException{
		Properties prop = new Properties();		
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\Resource\\Data.properties");	
		prop.load(fis);
		String browser =prop.getProperty("browser");
		String urlName =prop.getProperty("url");
		
		//String browser =System.getProperty("browser"); //this will use only when user wants send command from maven (mvn test -Dbrowser =chrome)
		if(browser.contains("chrome")){
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\BrowserDriver\\chromedriver.exe");
			ChromeOptions option = new ChromeOptions();
				if(browser.contains("headless")){
					System.out.println("Running in headless...");
					option.addArguments("headless");
				}			
			driver = new ChromeDriver(option); //option will be null if no headless. then run without headless mode.
			driver.get(urlName);
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		}else if(browser.equalsIgnoreCase("firefox")){
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\BrowserDriver\\geckodriver.exe");
			driver = new FirefoxDriver();
			driver.get(urlName);
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		}else{
			System.out.println("not configured for IE");
		}
		
		return driver;
	}
	
	public String getScreenShot(String testcasesName , WebDriver driver) throws IOException{
		TakesScreenshot ts = (TakesScreenshot)driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		String destinationPath =System.getProperty("user.dir")+"\\ScreenShots\\"+testcasesName+".png";
		//String destinationPath = "D:\\My_Projects\\UdemyE2EProject\\reports\\"+testcasesName+".png";
		org.apache.commons.io.FileUtils.copyFile(source, new File(destinationPath));
		return destinationPath;
	}

}
