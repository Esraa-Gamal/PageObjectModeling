package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class EmailProductToFriendPage extends PageBase
{

	public EmailProductToFriendPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(id="FriendEmail")
	WebElement friendEmailTxt;
	
	@FindBy(id="YourEmailAddress")
	WebElement myEmailTxt;
	
	@FindBy(id="PersonalMessage")
	public WebElement message;
	
	@FindBy(name= "send-email")
	WebElement sendEmailBtn;
	
	//@FindBy(css="div.result")
	@FindBy(className="result")
	WebElement resultMsg;
	
	public void openSendEmail()
	{
		
	}
	
	public void SendEmailToFriend(String friendEmail, String PersonalMessage)
	{
		setTextElementText(friendEmailTxt, friendEmail);
		setTextElementText(message, PersonalMessage);
		clickBtn(sendEmailBtn);
	}
	
}


