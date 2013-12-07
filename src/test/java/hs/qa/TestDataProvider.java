package hs.qa;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TestDataProvider {

	private static String testNGFile = "data-provider.xml";
	XMLTestDataProvider dp;

	@Test(dataProvider = "data")
	public void verifyInputData( Boolean enabled, String name ) {
		
		
		if ( enabled ) {
			System.out.println( enabled + ", " + name );
		} else {
			System.out.println( enabled + ", " + name );
		}
		
		
		dp.printSuiteVertical();
		
		Assert.assertTrue( true );
	}
	
	@DataProvider(name = "data")
	public Object[][] getData() {
		dp = new XMLTestDataProvider( testNGFile );
		return dp.getEighteenColumnData();		
	}

}
