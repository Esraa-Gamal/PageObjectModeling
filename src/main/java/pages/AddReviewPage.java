package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AddReviewPage extends PageBase {

	public AddReviewPage(WebDriver driver) {
		super(driver);
		
	}
	
	@FindBy(id="AddProductReview_Title")
	WebElement ReviewTitleTxt;
	
	@FindBy(id="AddProductReview_ReviewText")
	WebElement ReviewTextTxt;
	
	@FindBy(id="addproductrating_5")
	public WebElement rating5RdoBtn;
	
	//@FindBy(css="input.button-1.write-product-review-button")
	
	@FindBy(name="add review")
	public WebElement submitReviewButton;
	
	@FindBy(css="div.result")
	public WebElement reviewNotification;
	
	public void AddProductReview(String reviewTitle, String reviewText)
	{
		setTextElementText(ReviewTitleTxt, reviewTitle);
		setTextElementText(ReviewTextTxt, reviewText);
		clickBtn(rating5RdoBtn);
		clickBtn(submitReviewButton);
	}

}
