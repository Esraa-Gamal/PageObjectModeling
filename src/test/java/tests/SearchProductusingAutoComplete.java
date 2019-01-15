package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.ProductDetailsPage;
import pages.SearchPage;

public class SearchProductusingAutoComplete extends TestBase
{
	String productName= "Apple MacBook Pro 13-inch";
	SearchPage SearchObject;
	ProductDetailsPage detailsObject;
	@Test
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
}
