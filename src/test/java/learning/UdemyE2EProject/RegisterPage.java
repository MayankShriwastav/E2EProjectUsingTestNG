package learning.UdemyE2EProject;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import PageObjects.HomePageObj;
import PageObjects.LoginPageObj;
import PageObjects.RegisterPageObj;
import Resource.Base;

public class RegisterPage extends Base{
	

	WebDriver driver;
		
	public void navigateToRegister() throws IOException, InterruptedException{
		HomePageObj hp = new HomePageObj(driver);
		hp.register().click();
		Thread.sleep(3000);
	}
	
	@Test
	public void register() throws IOException, InterruptedException{
		HomePage hp = new HomePage();
		driver =hp.launchApp();
		navigateToRegister();
		RegisterPageObj rpo = new RegisterPageObj(driver);
		rpo.fullName().sendKeys("Mayank");
		rpo.email().sendKeys("abc@gmail.com");
		rpo.password().sendKeys("123456");
		rpo.confirmPassword().sendKeys("123456");		
	}
	

	@AfterTest
	public void close(){
		driver.close();
	}
	
}
