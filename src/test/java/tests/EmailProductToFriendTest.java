package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.EmailProductToFriendPage;
import pages.HomePage;
import pages.Login;
import pages.ProductDetailsPage;
import pages.SearchPage;
import pages.UserRegisterationPage;

public class EmailProductToFriendTest extends TestBase
{
	/*
	 * 1- user Registration
	 * 2- search product automatically
	 * 3- Email to Friend
	 */
	
	HomePage homeObject;
	UserRegisterationPage registerObject;
	Login loginObject;
	String productName= "Apple MacBook Pro 13-inch";
	SearchPage SearchObject;
	ProductDetailsPage detailsObject;
	EmailProductToFriendPage emailObject;

	
	@Test(priority=1, alwaysRun=true)
	public void UserCanRegister()
	{
		homeObject = new HomePage(driver);
		homeObject.openRegistrationPage();
		registerObject = new UserRegisterationPage(driver);
		registerObject.userRegisteration("Esraa", "Gamal", "test12@esraa12.com", "12345678");

		Assert.assertTrue(registerObject.successMsg.getText().contains("Your registration completed"));

	}
	
	//Search Product
	
	@Test(priority=2)
	public void userCanSearchwithAutoComplete()
	{
		try {
			SearchObject= new SearchPage(driver);
			SearchObject.productSearchUsingAutoTest("MacB");
			detailsObject= new ProductDetailsPage(driver);
			Assert.assertTrue(detailsObject.productNamebreadCrumb.getText().equalsIgnoreCase(productName));
		}
		catch(Exception e)
		{
			System.out.println("Error occured: "+e.getMessage());
		}
		
	}
	
	//Email to friend
	@Test(priority=3)
	public void userCanSendEmail()
	{
		detailsObject.openFriendEmail();
		emailObject= new EmailProductToFriendPage(driver);
		emailObject.SendEmailToFriend("aaa@s.com", "Testing");
		Assert.assertTrue(emailObject.message.getText().contains("Your message has been sent"));
	}
	
	

	@Test(priority=4)
	public void userCanLogOut()
	{
		registerObject.userLogOut();
	}

	
}
  