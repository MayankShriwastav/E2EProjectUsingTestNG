package learning.UdemyE2EProject;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import PageObjects.HomePageObj;
import PageObjects.LoginPageObj;
import Resource.Base;

public class LoginPage extends Base{
	WebDriver driver;
	
	public void navigateToLogin() throws IOException, InterruptedException{
		HomePageObj hp = new HomePageObj(driver);
		hp.login().click();
		Thread.sleep(5000);
	}
	
	@Test (dataProvider = "credentials")
	public void login(String username, String password) throws IOException, InterruptedException{
		HomePage hp = new HomePage();
		driver =hp.launchApp();
		navigateToLogin();
		LoginPageObj lp = new LoginPageObj(driver);
		lp.userName().sendKeys(username);
		lp.password().sendKeys(password);
		lp.submit().click();
		driver.close();
	}

	@DataProvider
	public Object[][] credentials(){
		Object[][] data = new Object[2][2];
		data[0][0] ="NonRestrictedUser@gmail.com";
		data[0][1] ="NonRestricted123";
		data[1][0] ="RestrictedUser@gmail.com";
		data[1][1] ="Restricted123";
		return data;
	}
	
/*	@AfterTest
	public void close(){
		driver.close();
	}*/
}
