package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterPageObj {
	
	WebDriver driver;
	public RegisterPageObj(WebDriver driver){
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	private @FindBy(id ="user_name") WebElement fullName;
	
	private @FindBy(id ="user_email") WebElement email;
	
	private @FindBy(id ="user_password") WebElement password;
	
	private @FindBy(id ="user_password_confirmation") WebElement confirmPassword;
	
	public WebElement fullName(){
		return fullName;
	}
	public WebElement email(){
		return email;
	}	
	public WebElement password(){
		return password;
	}
	public WebElement confirmPassword(){
		return confirmPassword;
	}

}
