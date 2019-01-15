package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.Login;
import pages.ProductDetailsPage;
import pages.SearchPage;
import pages.UserRegisterationPage;

public class AddToWishListTest extends TestBase
{
	
	
	
	/*
	 * 1- Register
	 * 2- search
	 * 3- add to wish list
	 * 4- logOut
	 */
	HomePage homeObject;
	UserRegisterationPage registerObject;
	Login loginObject;
	String productName= "Apple MacBook Pro 13-inch";
	SearchPage SearchObject;
	ProductDetailsPage detailsObject;

	
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
	
	@Test(priority=3)
	public void userCanAddToWishList()
	{
		detailsObject =new ProductDetailsPage(driver);
		detailsObject.addToWishList();
		Assert.assertTrue(detailsObject.notificationMsg.getText().contains("The product has been added to your wishlist"));

	}
	
	@Test(priority=4)
	public void userCanLogOut()
	{
		registerObject.userLogOut();
	}

}
