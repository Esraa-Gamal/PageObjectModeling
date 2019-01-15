package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Login extends PageBase  {

	public Login(WebDriver driver) 
	{
		super(driver);

	}
	
	@FindBy(id="Email")
	WebElement emailTxtBox;
	
	@FindBy(id="Password")
	WebElement passwordTxtBox;
	
	@FindBy(css="input.button-1.login-button")
	WebElement loginBtn;
	
	public void userLogin(String email, String password)
	{
		setTextElementText(emailTxtBox, "");
		setTextElementText(passwordTxtBox, "");
		clickBtn(loginBtn);
	}

}
