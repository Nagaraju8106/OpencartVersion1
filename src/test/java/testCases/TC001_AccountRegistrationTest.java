package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;
import testBase.BaseClass;

public class TC001_AccountRegistrationTest extends BaseClass{
	@Test(groups= {"Regression","Master"})
	public void Verify_account_registration() throws InterruptedException	
	{	
		logger.info("***Starting TC))!_AccountRegistrationTest...***");
		try
		{
			
		HomePage hp = new HomePage(driver);
		hp.ClickMyAccount();
		logger.info("Clicked on My Account link....");
		hp.ClickRegister();
		logger.info("Clicked on registred link...");
	
AccountRegistrationPage regpage= new AccountRegistrationPage(driver);
		
		logger.info("Providing customer details...");
		regpage.setFirstName(randomString().toUpperCase());
		regpage.setlastName(randomString().toUpperCase());
		regpage.setEmail(randomString()+"@gmail.com");
		regpage.setTelephone(randomNumber());
		
		String password= randomAlphaNumeric();
		regpage.setPassword(password);
		regpage.setConfirmPassword(password);
		regpage.setPrivacypolicy();
		regpage.clickContinue();
		Thread.sleep(10000);
		logger.info("Validating expected message....");
		String confmsg= regpage.getConfirmationMsg();
		
		if(confmsg.equals("Your Account Has Been Created!"))
		{
			Assert.assertTrue(true);
		}
		else
		{
			logger.error("Test Failed....");
			logger.debug("Debug logs..");
			Assert.assertTrue(false);
		}
		
		Assert.assertEquals(confmsg,"Your Account Has Been Created!");
		
	}		catch(Exception e)
	{
		
		Assert.fail();
	}		logger.info("*** Finished TC001_AccountRegistrationTest..");
		
}
}
	