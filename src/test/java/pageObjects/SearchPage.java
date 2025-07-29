package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchPage extends BasePage{

	public SearchPage(WebDriver driver) {
		super(driver);
		
	}	
		
		@FindBy(xpath="//a[normalize-space()='MacBook']")WebElement productinfo;
		
		public boolean isProductExists(String string)
		{
			try
			{
				return (productinfo.isDisplayed());
			}
			catch(Exception e)
			{
				return false;
			}
		}
		
	

}
