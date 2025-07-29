package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.annotations.Test;
@Test
public class HomePage extends BasePage{

		public HomePage(WebDriver driver)
		
		{
			super(driver);
		}
		
		@FindBy(xpath="//ul[@class='dropdown-menu dropdown-menu-right']//a[normalize-space()='Register']") 
		WebElement lnkRegister;
		@FindBy(xpath="//i[@class='fa fa-user']") WebElement lnkMyaccount;
		
		@FindBy(xpath="//a[normalize-space()='Login']") WebElement linkLogin;
		
		@FindBy(xpath="//input[@placeholder='Search']")WebElement searchoption;
		@FindBy(xpath="//i[@class='fa fa-search']")WebElement searchbtn;
		
		public void ClickMyAccount()
		{
			lnkMyaccount.click();
		}
		public void ClickRegister()
		{
			lnkRegister.click();
		}
		public void ClickLogin()
		{
			linkLogin.click();
			
		}
		public void searching()
		{
			searchoption.click();
		}
		public void product(String pro)
		{
			searchoption.sendKeys(pro);
		}
		public void search()
		{
			searchbtn.click();
		}

}
