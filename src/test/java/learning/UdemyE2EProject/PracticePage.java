package learning.UdemyE2EProject;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import PageObjects.HomePageObj;
import PageObjects.LoginPageObj;
import PageObjects.PracticePageObj;
import PageObjects.RegisterPageObj;
import Resource.Base;
import junit.framework.Assert;

public class PracticePage extends Base{
	

	WebDriver driver;
		
	public void navigateToPractice() throws IOException, InterruptedException{
		HomePageObj hp = new HomePageObj(driver);
		hp.practice().click();
		Thread.sleep(3000);
	}
	
	@Test
	public void prectice() throws IOException, InterruptedException{
		HomePage hp = new HomePage();
		driver =hp.launchApp();
		navigateToPractice();
		PracticePageObj ppo = new PracticePageObj(driver);
		Assert.assertTrue(ppo.pageText().isDisplayed());	
		Assert.assertTrue(false);	//delebrately failed this testcase--> to check print screen for only failed tc with tc name
	}

	@AfterTest
	public void close(){
		driver.close();
	}
}
