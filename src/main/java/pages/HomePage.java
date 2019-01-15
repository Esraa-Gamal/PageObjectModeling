package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class HomePage extends PageBase
{

	public HomePage(WebDriver driver) 
	{
		super(driver);
		jse= (JavascriptExecutor) driver;
		action= new Actions(driver);
	}


	@FindBy (linkText="Register")
	WebElement registerLink;
	@FindBy(linkText="Log in")
	WebElement loginLink;
	
	@FindBy(linkText="Contact us")
	WebElement contactLink;
	
	@FindBy(id="customerCurrency")
	WebElement currencyList;
	
	@FindBy(linkText="computers")
	WebElement computerHoverMenu;
	
	@FindBy(linkText="notebooks")
	WebElement noteBooksMenu;
	
	


	public void openRegistrationPage()
	{
		//registerLink.click();
		clickBtn(registerLink);
	}

	public void openLoginPage()
	{
		clickBtn(loginLink);
	}

	public void openConatcUsPage()
	{
		scrollToButton();
		clickBtn(contactLink);
	}
	
	public void changeCurrencyList()
	{
		select = new Select(currencyList);
		select.selectByVisibleText("Euro");
		
	}
	
	public void OpenNoteBooksMenu()
	{
		//clickBtn(noteBooksMenu);
		action.moveToElement(computerHoverMenu).moveToElement(noteBooksMenu).click().build().perform();
	}

}
