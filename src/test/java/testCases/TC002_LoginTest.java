package testCases;

import java.util.logging.Logger;

import org.testng.Assert;
import org.testng.annotations.Test;


import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;

public class TC002_LoginTest extends BaseClass{
	
	@Test(groups={"Sanity","Master"})
	public void verify_login()
	{
		logger.info("***Starting TC002_ LoginTest***");
		//HomePage
		try
		{
		HomePage hp= new HomePage(driver);
		hp.ClickMyAccount();
		hp.ClickLogin();
		
		//Login page
		LoginPage lp= new LoginPage(driver);
		lp.setEmailAddress(p.getProperty("email"));
		lp.setPassword(p.getProperty("password"));
		lp.clickLogin();
		
		//MyAccount
		MyAccountPage macc= new MyAccountPage(driver);
		boolean targetpage=macc.isMyAccountPageExists();
		Assert.assertTrue(targetpage);//Assert.assertEquals(targetpage, true, "Login Failed");
		}
		catch(Exception e)
		{
			Assert.fail();
		}
		logger.info("****Finished TC02_LoginTest****");
	}

}
