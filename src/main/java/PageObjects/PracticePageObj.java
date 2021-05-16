package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PracticePageObj {
	
	WebDriver driver;
	public PracticePageObj(WebDriver driver){
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	private @FindBy(css =".blinkingText") WebElement pageText;	
	
	public WebElement pageText(){
		return pageText;

	}
}
