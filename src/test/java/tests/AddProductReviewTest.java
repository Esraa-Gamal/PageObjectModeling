package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.AddReviewPage;
import pages.HomePage;
import pages.Login;
import pages.ProductDetailsPage;
import pages.SearchPage;
import pages.UserRegisterationPage;

public class AddProductReviewTest extends TestBase 
{
	/*
	 * 1- userRegisteration
	 * 2- search for Product
	 * 3- addReview
	 * 4- log out
	 */
	HomePage homeObject;
	UserRegisterationPage registerObject;
	Login loginObject;
	String productName= "Apple MacBook Pro 13-inch";
	SearchPage SearchObject;
	ProductDetailsPage detailsObject;
	AddReviewPage reviewObject;
	

	
	@Test(priority=1, alwaysRun=true)
	public void UserCanRegister()
	{
		homeObject = new HomePage(driver);
		homeObject.openRegistrationPage();
		registerObject = new UserRegisterationPage(driver);
		registerObject.userRegisteration("Esraa", "Gamal", "test312@esraa12.com", "12345678");

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
	public void userCanAddReview()
	{
		//detailsObject= new ProductDetailsPage(driver);
		detailsObject.openAddReviewPage();
		reviewObject=new AddReviewPage(driver);
		reviewObject.AddProductReview("Excellent", "Amazing test");
		Assert.assertTrue(reviewObject.reviewNotification.getText().contains("Product review is successfully added"));
	}
	
	

	@Test(priority=4)
	public void userCanLogOut()
	{
		registerObject.userLogOut();
	}

}
