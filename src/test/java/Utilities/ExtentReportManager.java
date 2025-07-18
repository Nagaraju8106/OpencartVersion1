package Utilities;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.ImageHtmlEmail;
import org.apache.commons.mail.resolver.DataSourceUrlResolver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.annotations.Listeners;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import testBase.BaseClass;
@Listeners
public class ExtentReportManager implements ITestListener{
		public  ExtentSparkReporter sparkReporter;// UI of the report
		public  ExtentReports extent;// Populate common info on the report
		public ExtentTest test;// create test case entry's in the report and update the status of the methods
		
		String repName;
		public void onStart(ITestContext testContext)
		{
		/*	 SimpleDateFormat df= new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss");
			 Date dt= new Date();
			 String currentdatetimestamp= df.format(dt); */
			 
			
			String timeStamp= new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());// time stamp 
			repName= "Test-Reporter-" + timeStamp + ".html";
			
			sparkReporter= new ExtentSparkReporter(".\\reports\\" +repName);//Specifications
			sparkReporter.config().setDocumentTitle("opencart Automation Report");//Title of the report
			sparkReporter.config().setReportName("opencart Functional Testing");// Name of the report
			sparkReporter.config().setTheme(Theme.DARK);
			
			extent = new ExtentReports();
			extent.attachReporter(sparkReporter);
			extent.setSystemInfo("Application","Localhost");
			extent.setSystemInfo("Madule","Admin");
			extent.setSystemInfo("Sub Module","Customers");
			extent.setSystemInfo("User Name",/*System.getProperty("user.name*/"Nagaraju");
			extent.setSystemInfo("Environment","QA");
			
			String os= testContext.getCurrentXmlTest().getParameter("os");
			extent.setSystemInfo("Operating System",os);
			
			String browser= testContext.getCurrentXmlTest().getParameter("browser");
			extent.setSystemInfo("Browser",browser);
			
			List<String> includedGroups = testContext.getCurrentXmlTest().getIncludedGroups();
			if(!includedGroups.isEmpty())
			{
				extent.setSystemInfo("Groups", includedGroups.toString());
				
			}
		}
		public void onTestSuccess(ITestResult result)
		{
			test= extent.createTest(result.getTestClass().getName());//Create a new entity in the report
			test.assignCategory(result.getMethod().getGroups());// to display groups in report
			test.log(Status.PASS,result.getName()+"got successfully executed..");//update the status pass/failed/skipped
			
		}
		public void onTestFailure(ITestResult result)
		{
			test=extent.createTest(result.getTestClass().getName());
			test.assignCategory(result.getMethod().getGroups());// To display groups in report
			test.log(Status.PASS,result.getName()+"Got successfully executed");
			test.log(Status.FAIL,"Test case FAILED is :"+result.getThrowable());
			
			try
			{
				String imgPath = new BaseClass().captureScreen(result.getName());
				test.addScreenCaptureFromPath(imgPath);
			}
			catch(Exception e1)
			{
				e1.printStackTrace();
			}
		}
		public void onTestSkipped(ITestResult result)
		{
			test= extent.createTest(result.getTestClass().getName());
			test.assignCategory(result.getMethod().getGroups());
			
			test.log(Status.SKIP,result.getName()+"got skipped");
			test.log(Status.INFO,result.getThrowable().getMessage());
		
		try
		{
			String imgPath=  new BaseClass().captureScreen(result.getName());
			test.addScreenCaptureFromPath(imgPath);
		}
		catch(Exception e1)
		{
			e1.printStackTrace();
		}
		}
		public void onFinish(ITestContext testContext)
		{
			extent.flush();
			
			String pathOfExtendReport = System.getProperty("user.dir")+"\\reports\\"+repName;
			File extendReport= new File(pathOfExtendReport);
			
			try
			{
				Desktop.getDesktop().browse(extendReport.toURI());
			}
			catch(IOException e)
			{
				e.printStackTrace();
			}
			
		/*	
			 try
			 {
				 URL url= new URL("file://"+System.getProperty("user.dir")+"\\reports\\"+repName);
			 
			  // Create the email messeage
			  ImageHtmlEmail email = new ImageHtmlEmail();
			  email.setDataSourceResolver(new DataSourceUrlResolver(url));
			  email.setHostName("smtp.googlemail.com");
			  email.setSmtpPort(465);
			  email.setAuthenticator(new DefaultAuthenticator("nagarajukatta754@gmai.com","Raju@1234"));
			  email.setSSLOnConnect(true);
			  email.setFrom("nagarajukatta754@gmail.com");//sender
			  email.setSubject("Test Result");
			  email.setMsg("Please find the Attached Reports.....");
			  email.addTo("kattanagraju216@gmail.com"); // Receiver
			  email.attach(url, "extend report", "please check report....");
			  email.send();// send the email
			  }
			  catch(Exception e)
			  {e.printStackTrace();
			   }
			*/ 
		}

}
