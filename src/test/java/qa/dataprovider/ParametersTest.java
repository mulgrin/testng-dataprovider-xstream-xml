package qa.dataprovider;

import org.apache.commons.lang3.StringUtils;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import qa.dataprovider.XMLTestDataProvider;
import qa.dataprovider.def.OptionalArgsMap;
import qa.dataprovider.def.RequiredArgsList;

public class ParametersTest {
	
	private static String testData = "data-provider.xml";

	@Test(dataProvider = "testdata")
	public void printHorizontal( RequiredArgsList reqArgs, OptionalArgsMap optArgs ) {
		System.out.println("\n----------------\nPrint horizontal test:\n----------------");
		
		System.out.print( "[ " + reqArgs.getEnabled() + ", " + reqArgs.getTestName() + ", " + reqArgs.getEnvironment() + ", " +
		    reqArgs.getTestLocale() + ", " + reqArgs.getBrowser() + ", " );
		
		System.out.println( optArgs.getArgByName("url") + ", " + optArgs.getArgByName("username") + ", " + 
		    optArgs.getArgByName("password") + ", " + optArgs.getArgByName("verifies") + ", " +
		    optArgs.getArgByName("aNumber") + " ]" );
		
		System.out.println("----------------\nFinished printHorizontal test.\n");
		Assert.assertTrue( true );
	}

	@Test(dataProvider = "testdata")
	public void printVertical( RequiredArgsList reqArgs, OptionalArgsMap optArgs ) {
		System.out.println("\n----------------\nPrint vertical test:\n----------------");
		
		System.out.println("Test enabled: " + reqArgs.getEnabled() );
		System.out.println("Test name: " + reqArgs.getTestName() );
		System.out.println("Environment: " + reqArgs.getEnvironment() );
		System.out.println("Locale: " + reqArgs.getTestLocale() );
		System.out.println("Browser: " + reqArgs.getBrowser() );
		
		System.out.println("App URL: " + optArgs.getArgByName("url") );
		System.out.println("Username: " + optArgs.getArgByName("username") );
		System.out.println("Password: " + optArgs.getArgByName("password") );		
		System.out.println("Verify: " + optArgs.getArgByName("verifies") );
		System.out.println("A number: " + optArgs.getArgByName("aNumber") );
		
		System.out.println("----------------\nFinished printVertical test.\n");
	}

	@DataProvider(name = "testdata")
	public Object[][] getTestData() {
		XMLTestDataProvider dp = new XMLTestDataProvider( testData );
		return dp.getCompactData();
	}

}
