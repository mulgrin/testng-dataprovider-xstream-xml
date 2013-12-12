package qa.dataprovider;

import org.apache.commons.lang3.StringUtils;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import qa.dataprovider.XMLTestDataProvider;
import qa.dataprovider.def.OptionalArgs;
import qa.dataprovider.def.RequiredArgs;

public class ParametersTest {
	
	private static String testData = "data-provider.xml";

	@Test(dataProvider = "testdata")
	public void printHorizontal( RequiredArgs reqArgs, OptionalArgs optArgs ) {
		System.out.println("\n----------------\nPrint horizontal test:\n----------------");
		System.out.println( "[ " + reqArgs.getEnabled() + ", " + reqArgs.getTestName() + ", " + reqArgs.getEnvironment() + ", " +
		    reqArgs.getTestLocale() + ", " + reqArgs.getBrowser() + ", " + optArgs.getArgByIndex(0) + ", " 
				+ optArgs.getArgByIndex(1) + ", " + StringUtils.join( optArgs.getArgByIndex(2), "," ) + " ]" ); 
		System.out.println("----------------\nFinished printHorizontal test.\n");
		Assert.assertTrue( true );
	}

	@Test(dataProvider = "testdata")
	public void printVertical( RequiredArgs reqArgs, OptionalArgs optArgs ) {
		System.out.println("\n----------------\nPrint vertical test:\n----------------");
		System.out.println("Test enabled: " + reqArgs.getEnabled() );
		System.out.println("Test name: " + reqArgs.getTestName() );
		System.out.println("Environment: " + reqArgs.getEnvironment() );
		System.out.println("Locale: " + reqArgs.getTestLocale() );
		System.out.println("Browser: " + reqArgs.getBrowser() );
		System.out.println("App URL: " + optArgs.getArgByIndex(0) );
		System.out.println("Username: " + optArgs.getArgByIndex(1) );
		System.out.println("Verify: " + StringUtils.join( optArgs.getArgByIndex(2), "," ) );
		System.out.println("----------------\nFinished printVertical test.\n");
	}

	@DataProvider(name = "testdata")
	public Object[][] getTestData() {
		XMLTestDataProvider dp = new XMLTestDataProvider( testData );
		return dp.getCompactData();
	}

}
