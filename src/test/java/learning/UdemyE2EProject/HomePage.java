package learning.UdemyE2EProject;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import PageObjects.HomePageObj;
import PageObjects.LoginPageObj;
import Resource.Base;
import junit.framework.Assert;

public class HomePage extends Base{
	
	WebDriver driver;
	
	@Test
	public WebDriver launchApp() throws IOException{
		driver = InitializedDriver();		
		return driver;
	}

	@Test
	public void verification() throws IOException{
		driver = InitializedDriver();	
		HomePageObj hpo = new HomePageObj(driver);
		System.out.println("Expected	:"+hpo.courses().getText());
		Assert.assertEquals("FEATURED COURSES", hpo.courses().getText());
		Assert.assertTrue(hpo.nevigationBar().isDisplayed());
		System.out.println("Feature Courses and Nevigation bar is available");
	}
	
	@AfterTest
	public void close(){
		driver.close();
	}

}
