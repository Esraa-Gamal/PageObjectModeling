package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;



public class UserRegisterationPage extends PageBase
{

	public UserRegisterationPage(WebDriver driver) 
	{
		super(driver);
	}
	@FindBy(id="gender-male")
	WebElement genderRadioBtn;

	@FindBy(id="FirstName")
	WebElement fNTxBox;

	@FindBy(id="LastName")
	WebElement lNTxBox;

	@FindBy(id="Email")
	WebElement emailBox;

	@FindBy(id="Password")
	WebElement passwordTxtBox;

	@FindBy(id="ConfirmPassword")
	WebElement confirmPassordTxtBox;

	@FindBy(id="register-button")
	WebElement registerBtn;

	@FindBy(css="div.result")
	public WebElement successMsg;

	@FindBy(linkText="Log out")
	public WebElement logoutLink;

	@FindBy(linkText="My account")
	WebElement myAccountLink;
	
	public void userRegisteration(String firstName, String lastName, String email, String Password)
	{
		//genderRadioBtn.click();
		clickBtn(genderRadioBtn);
		//fNTxBox.sendKeys("firstName");
		setTextElementText(fNTxBox, firstName);
		//lNTxBox.sendKeys("lastName");
		setTextElementText(lNTxBox, lastName);
		//emailBox.sendKeys("email");
		setTextElementText(emailBox, email);
		//passwordTxtBox.sendKeys("Password");
		setTextElementText(passwordTxtBox, Password);
		//confirmPassordTxtBox.sendKeys("Password");
		setTextElementText(confirmPassordTxtBox, Password);
		//registerBtn.click();
		clickBtn(registerBtn);

	}

	public void userLogOut()
	{
		clickBtn(logoutLink);

	}

	public void openMyAccountPage()
	{
		clickBtn(myAccountLink);
	}











}
