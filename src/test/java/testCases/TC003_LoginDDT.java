package testCases;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import Utilities.DataProviders;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;

/* Data is valid - login success -test pass -Logout
 Data is valid --Login failed- test fail
 
 Data is invalid -Login success -test failed-logout
 Data is invalid--login failed -test failed */

public class TC003_LoginDDT extends BaseClass {
	
	@Test(dataProvider="LoginData", dataProviderClass=DataProviders.class,groups="Datadriven")//Getting dataproviders from defferent class
	
	public void verify_loginDDT(String email, String pwd, String exp)
	{
		logger.info("***Startng TC003_LoginDDT test****");
		try
		{
		HomePage hp= new HomePage(driver);
		hp.ClickMyAccount();
		hp.ClickLogin();
		
		//Login page
		LoginPage lp= new LoginPage(driver);
		lp.setEmailAddress(email);
		lp.setPassword(pwd);
		lp.clickLogin();
		
		//MyAccount
		MyAccountPage macc= new MyAccountPage(driver);
		boolean targetpage=macc.isMyAccountPageExists();
	
	if(exp.equalsIgnoreCase("Valid"))
	{
		if(targetpage==true)
		{
			macc.clickLogout();
			Assert.assertTrue(true);
			
		}
		else
		{
			Assert.assertTrue(false);
		}
	}
	if(exp.equalsIgnoreCase("invalid"))
	{
		if(targetpage==true)
		{
			macc.clickLogout();
			Assert.assertTrue(false);
		}
		else
		{
			Assert.assertTrue(true);
		}
	}
		}
		catch(Exception e)
		{
			Assert.fail();
		}
	logger.info("***Completing TC003_LoginDDT test****");

}
}