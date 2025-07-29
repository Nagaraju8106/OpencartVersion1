package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.SearchPage;
import testBase.BaseClass;


public class TC004_SearchProductTest extends BaseClass {
	
	@Test(groups= {"Master"})
	
	public void verify_Productsearch()
	{
		logger.info("Starting TC004_SearchProductTest");
	try
	{
		Thread.sleep(10000);
	HomePage hm= new HomePage(driver);
	
	//hm.searching();
	hm.product("mac");
	hm.search();
	SearchPage sg= new SearchPage(driver);
	sg.isProductExists("MacBook");
	
	Assert.assertEquals(sg.isProductExists("MacBook"),true);
	Thread.sleep(20000);
}
	catch(Exception e)
	{
		Assert.fail();
	}
	logger.info("Finshed...TC004_SearchProductTest..");
	}}
