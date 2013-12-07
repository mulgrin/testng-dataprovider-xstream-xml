package hs.qa;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestDataProvider {

	private static String testNGFile = "data-provider.xml";

	@Test
	public void verifyInputData() {
		
		new XMLTestDataProvider( testNGFile );
		
		Assert.assertTrue(true);
	}

}
