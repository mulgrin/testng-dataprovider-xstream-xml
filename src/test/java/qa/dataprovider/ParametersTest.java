package qa.dataprovider;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import qa.dataprovider.XMLTestDataProvider;

public class ParametersTest {
	
	private static String testData = "data-provider.xml";

	@Test(dataProvider = "data18")
	public void printHorizontal( Boolean en, String tName, String flag, String loc, String browser, String appUrl, 
			String uname, String passw, String env, String client, String role, String view, String spec, 
			String brand, String start, String area, String query, List<String> verify ) {
		System.out.println("\n----------------\nPrint horizontal test:\n----------------");
		System.out.println( "[ " + en + ", " + tName + ", " + flag + ", " + loc + ", " + browser + ", " + appUrl + ", " 
				+ uname + ", " + passw + ", " + env + ", " + client + ", " + role + ", " + view + ", " + spec + ", " 
				+ brand + ", " + start + ", " + area + ", " + query + ", " + StringUtils.join( verify, "," ) + " ]" ); 
		System.out.println("----------------\nFinished printHorizontal test.\n");
		Assert.assertTrue( true );
	}

	@Test(dataProvider = "data18")
	public void printVertical( Boolean en, String tName, String flag, String loc, String browser, String appUrl, 
			String uname, String passw, String env, String client, String role, String view, String spec, 
			String brand, String start, String area, String query, List<String> verify ) {
		System.out.println("\n----------------\nPrint vertical test:\n----------------");
		System.out.println("Test enabled: " + en );
		System.out.println("Test name: " + tName );
		System.out.println("Flag: " + flag );
		System.out.println("Locale: " + loc );
		System.out.println("Browser: " + browser );
		System.out.println("App URL: " + appUrl );
		System.out.println("Username: " + uname );
		System.out.println("Password: " + passw );
		System.out.println("Environment: " + env );
		System.out.println("Client: " + client );
		System.out.println("Role: " + role );
		System.out.println("View: " + view );
		System.out.println("Specialty: " + spec );
		System.out.println("Brand: " + brand );
		System.out.println("Start location: " + start );
		System.out.println("Search area: " + area );
		System.out.println("Query: " + query );
		System.out.println("Verify: " + StringUtils.join( verify, "," ) );
		System.out.println("----------------\nFinished printVertical test.\n");
	}

	@DataProvider(name = "data18")
	public Object[][] getTestData18() {
		XMLTestDataProvider dp = new XMLTestDataProvider( testData );
		return dp.getEighteenColumnData();
	}

}
