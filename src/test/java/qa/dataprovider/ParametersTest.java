package qa.dataprovider;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import qa.dataprovider.def.ArgObject;
import qa.dataprovider.def.TestArguments;

public class ParametersTest {
	
	private static String testData = "data-provider.xml";

	@Test(dataProvider = "testdata")
	public void printHorizontal( TestArguments testArgs ) {
		System.out.println("\n----------------\nPrint horizontal test:\n----------------");
		
		System.out.println( testArgs.toString() );
		
		System.out.println("----------------\nFinished printHorizontal test.\n");
		Assert.assertTrue( true );
	}

	@Test(dataProvider = "testdata")
	public void printVertical( TestArguments testArgs ) {
		System.out.println("\n----------------\nPrint vertical test:\n----------------");
		
		for ( ArgObject x: testArgs.getAllTestArguments() ) {
			System.out.println( x.getKey() + "[" + x.getType() + "]: " + x.getVal() );
		}
		
		System.out.println("----------------\nFinished printVertical test.\n");
	}

	@DataProvider(name = "testdata")
	public Object[][] getTestData() {
		System.out.println("Calling TestNG data provider method.");
		XMLDataHelper dp = new XMLDataHelper( testData );
		return dp.getArgumentsArrays();
	}

}
