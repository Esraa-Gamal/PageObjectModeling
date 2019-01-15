package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.ProductDetailsPage;
import pages.SearchPage;

public class ChangeCurrencyTest extends TestBase 
{
	HomePage homeObject;
	ProductDetailsPage detailsObject;
	SearchPage SearchObject;
	String productName= "Apple MacBook Pro 13-inch";
	
	@Test (priority=1)
	public void userCanChangeCurrency()
	{
		homeObject= new HomePage(driver);
		homeObject.changeCurrencyList();
		detailsObject= new ProductDetailsPage(driver);
		
		
	}
	
	@Test(priority=2)
	public void userCanSearchwithAutoComplete()
	{
		try {
			SearchObject= new SearchPage(driver);
			SearchObject.productSearchUsingAutoTest("MacB");
			detailsObject= new ProductDetailsPage(driver);
			Assert.assertTrue(detailsObject.productNamebreadCrumb.getText().equalsIgnoreCase(productName));
			Assert.assertTrue(detailsObject.productPriceLbl.getText().contains("€"));
			System.out.println("detailsObject.productPriceLbl.getText()");
		}
		catch(Exception e)
		{
			System.out.println("Error occured: "+e.getMessage());
		}
		
	}
}
