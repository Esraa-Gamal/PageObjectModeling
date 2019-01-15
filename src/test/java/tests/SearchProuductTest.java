package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.ProductDetailsPage;
import pages.SearchPage;

public class SearchProuductTest extends TestBase{
	String productName= "Apple MacBook Pro 13-inch";
	SearchPage SearchObject;
	ProductDetailsPage detailsObject;
	
	@Test
	public void userCanSearchForProduct()
	{
		SearchObject= new SearchPage(driver);
		SearchObject.productSearch(productName);
		detailsObject=new ProductDetailsPage(driver);
		SearchObject.openProductDetailsPage();
		//Assert.assertTrue(detailsObject.productNamebreadCrumb.getText().equalsIgnoreCase(productName));
		Assert.assertEquals(detailsObject.productNamebreadCrumb.getText(), productName);
	}
	
	
}
