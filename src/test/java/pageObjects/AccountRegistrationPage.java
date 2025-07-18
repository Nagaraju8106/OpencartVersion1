package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.annotations.Test;
@Test
public class AccountRegistrationPage extends BasePage{
		WebDriver driver;
		public AccountRegistrationPage(WebDriver driver)
		{
			super(driver);
		}
		@FindBy(xpath="//input[@id='input-firstname']")
			WebElement txtFirstname;
		@FindBy(xpath="//input[@id='input-lastname']")
			WebElement txtLastname;
		@FindBy(xpath="//input[@id='input-email']")
			WebElement txtEmail;
		@FindBy(xpath="//input[@id='input-telephone']")
			WebElement txtTelephone;
		@FindBy(xpath="//input[@id='input-password']")
			WebElement txtPassword;
		@FindBy(xpath="//input[@id='input-confirm']")
			WebElement txtConfirmPassword;
		@FindBy(xpath="//input[@name='agree']")
			WebElement chkdPolicy;
		@FindBy(xpath="//input[@value='Continue']")
			WebElement txtContinue;
		@FindBy(xpath="//h1[normalize-space()='Your Account Has Been Created!']")
			WebElement mgsConfirmation;
		
		public void setFirstName(String fname)
		{
			txtFirstname.sendKeys(fname);
		}
		public void setlastName(String lname)
		{
			txtLastname.sendKeys(lname);
		}
		public void setEmail(String email)
		{
			txtEmail.sendKeys(email);
		}
		public void setTelephone(String phn)
		{
			txtTelephone.sendKeys(phn);
		}
		public void setPassword(String pwd)
		{
			txtPassword.sendKeys(pwd);
		}
		public void setConfirmPassword(String confpwd)
		{
			txtConfirmPassword.sendKeys(confpwd);
		}
		public void setPrivacypolicy()
		{
			chkdPolicy.click();
		}
		public void clickContinue()
		{
			txtContinue.click();
		
//		Actions act= new Actions(driver);
//		act.moveToElement(txtContinue).click().perform();
		}
		
		public String getConfirmationMsg()
		{
			try
			{
				return(mgsConfirmation.getText());
			}
			catch(Exception e)
			{
				return (e.getMessage());
			}
		}
	


}
