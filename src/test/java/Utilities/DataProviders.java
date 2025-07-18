package Utilities;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class DataProviders {
	//Data Provider1
	
	@DataProvider(name="LoginData")
	public String [][] getData() throws IOException
	{
		String path = ".\\testData\\opencart.LoginData.xlsx";//taking xl file from testData
		ExcelUtility xlutil= new ExcelUtility(path);//Create an object for Xlutility
		
		int totalrows = xlutil.getRowCount("Sheet1");
		int totalcols= xlutil.getCellCount("Sheet1", 1);
		
		String logindata[][]= new String [totalrows][totalcols];//Create for two dimentional array which can store 
		
		for(int i=1;i<=totalrows;i++)// read the data from xl storing in two dimensional array
		{
			for(int j=0;j<totalcols;j++)// i is the rows j is col
			{
				logindata[i-1][j]=xlutil.getCellData("Sheet1", i,j); //1,0
				
			}
		}
		return logindata;//returning two dimensional array
		
	}
	//Data provider2
	//Data provider3
	//Data provider4
	
	
}
