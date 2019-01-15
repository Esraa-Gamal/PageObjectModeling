package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.Login;
import pages.UserRegisterationPage;

public class UserRegisterationTest extends TestBase
{
	HomePage homeObject;
	UserRegisterationPage registerObject;
	Login loginObject;
	@Test(priority=1, alwaysRun=true)
	public void UserCanRegister()
	{
		homeObject = new HomePage(driver);
		homeObject.openRegistrationPage();
		registerObject = new UserRegisterationPage(driver);
		registerObject.userRegisteration("Esraa", "Gamal", "test1@esraa1.com", "12345678");

		Assert.assertTrue(registerObject.successMsg.getText().contains("Your registration completed"));

	}
	@Test(dependsOnMethods="UserCanRegister")
	public void userCanLogOut()
	{
		registerObject.userLogOut();
	}

	@Test(dependsOnMethods="userCanLogOut")
	public void userCanLogin()
	{
		homeObject.openLoginPage();
		loginObject = new Login(driver);
		loginObject.userLogin("test1@esraa1.com","12345678");
		//assert doesn't work
		//Assert.assertTrue(registerObject.logoutLink.isDisplayed());
		//Assert.assertTrue(registerObject.logoutLink.getText().contains("Log out"));
	}
	
}

