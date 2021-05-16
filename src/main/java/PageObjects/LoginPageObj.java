package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPageObj {
	
	WebDriver driver;
	public LoginPageObj(WebDriver driver){
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	private @FindBy(id ="user_email")
	WebElement userName;
	
	private @FindBy(name =" password")
	WebElement password;
	
	private @FindBy(name ="commit")
	WebElement submit;
	
	public WebElement userName(){
		return userName;
	}
	public WebElement password(){
		return password;
	}
	public WebElement submit(){
		return submit;
	}

}
