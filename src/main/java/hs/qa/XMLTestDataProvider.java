package hs.qa;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import com.thoughtworks.xstream.XStream;

public class XMLTestDataProvider {
	
	private TestSuite testSuite;

	public XMLTestDataProvider( String fileName ) {		
		File testXML = new File( fileName );
        if ( !testXML.exists() ) {
        	System.out.println("Generating new default test data in xml file '" + fileName +  "'..." );
        	try {
				testXML.createNewFile();
				createDefaultSuiteFile( testXML );
			} catch (IOException e) {
				e.printStackTrace();
			}
        } else {
        	System.out.println("Loading test data from xml file '" + fileName +  "'..." );
        	XStream xStream = new XStream();
    		xStream.alias("suite", TestSuite.class);
            xStream.alias("test", TestCase.class);
    		xStream.processAnnotations(TestSuite.class);
    		xStream.processAnnotations(TestCase.class);
    		xStream.processAnnotations(MultiItems.class);
    		Object readObject = xStream.fromXML( testXML );
    		testSuite = (TestSuite)readObject;
        }
	}	
	
	public void createDefaultSuiteFile( File testXML ) 
	{
        TestSuite mySuite = new TestSuite( "Test 1", "http://username-string:access-key-string@ondemand.saucelabs.com:80/wd/hub" );
        mySuite.add( new TestCase( true, "Test 1", "portal1", "Grid", "Firefox", "http://mywebsite.com", "user1", "pass1", "Staging", 
        		"test1", "member", "New Window", "Biology", "Texas", "12345 Main St., Cheyenne, WY, 82001, US",
        		"Columbia, SC", "Parker, Peter", "Wolverine, Batman, Superman" ) );
        mySuite.add( new TestCase( true, "Test 2", "portal2", "Local", "Chrome", "http://mywebsite.com", "user2", "pass2", "Integration", 
        		"test2", "federated", "New Window", "Chemistry", "Texas", "12345 Main St., Cheyenne, WY, 82001, US",
        		"Columbia, SC", "Pumpkin, Peter", "Spiderman, Batman, Wonder Woman") );
        XStream xstream = new XStream();
        xstream.alias( "suite", TestSuite.class );
        xstream.alias( "test", TestCase.class );
        //xstream.alias( "list", MultiItems.class );
        String xml = xstream.toXML( mySuite );
        System.out.println( xml );
		FileWriter fw;
		try {
			fw = new FileWriter( testXML );
			fw.append( xml );
			fw.close();
		} catch ( IOException ioe ) {
			ioe.printStackTrace();
		}
		testSuite = mySuite;
	}
	
	private String getAppUrlByIndex( int idx ) {
		return testSuite.getTestByIndex(idx).getAppUrl();
	}
	
	private String getBrandByIndex( int idx ) {
		return testSuite.getTestByIndex(idx).getBrand();
	}
	
	private String getBrowserByIndex( int idx ) {
		return testSuite.getTestByIndex(idx).getBrowser();
	}
	
	private String getClientByIndex( int idx ) {
		return testSuite.getTestByIndex(idx).getClientIDP();
	}

	public Boolean getEnabledByIndex( int idx ) {
		return testSuite.getTestByIndex( idx ).getEnabled();
	}

	private String getEnvFlagByIndex( int idx ) {
		return testSuite.getTestByIndex(idx).getEnvFlag();
	}

	private String getEnvironmentByIndex( int idx ) {
		return testSuite.getTestByIndex(idx).getEnvironment();
	}

	private String getLocaleByIndex( int idx ) {
		return testSuite.getTestByIndex(idx).getLocale();
	}

	private String getNameQueryByIndex( int idx ) {
		return testSuite.getTestByIndex(idx).getNameQuery();
	}

	private String getPasswordByIndex( int idx ) {
		return testSuite.getTestByIndex(idx).getPassWord();
	}

	private String getRoleByIndex( int idx ) {
		return testSuite.getTestByIndex(idx).getRole();
	}

	private String getSearchAreaByIndex( int idx ) {
		return testSuite.getTestByIndex(idx).getSearchArea();
	}

	private String getSpecialtyByIndex( int idx ) {
		return testSuite.getTestByIndex(idx).getSpecialty();
	}

	private String getStartLocationByIndex( int idx ) {
		return testSuite.getTestByIndex(idx).getStartingLocation();
	}

	public String getTestNameByIndex( int idx ) {
		return testSuite.getAllTests().get( idx ).getName();
	}

	private String getUsernameByIndex( int idx ) {
		return testSuite.getTestByIndex(idx).getUserName();
	}

	public List<String> getVerifyListByIndex( int idx ) {		
		return testSuite.getTestByIndex( idx ).getVerifyList();	
	}

	private String getViewByIndex( int idx ) {
		return testSuite.getTestByIndex(idx).getView();
	}

	/**
	 * This is the TestNG DataProvider implementation
	 * Should return an Object[][] or Iterator<Object[]> data type
	 * @return
	 */
    public Object[][] getEighteenColumnData() {
    	Object[][] data = new Object[testSuite.size()][18];
    	for ( int i = 0; i < testSuite.size(); i++ ) {
    		data[i][0] = getEnabledByIndex(i);
    		data[i][1] = getTestNameByIndex(i);
    		data[i][2] = getEnvFlagByIndex(i);
    		data[i][3] = getLocaleByIndex(i);
    		data[i][4] = getBrowserByIndex(i);
    		data[i][5] = getAppUrlByIndex(i);
    		data[i][6] = getUsernameByIndex(i);
    		data[i][7] = getPasswordByIndex(i);
    		data[i][8] = getEnvironmentByIndex(i);
    		data[i][9] = getClientByIndex(i);
    		data[i][10] = getRoleByIndex(i);
    		data[i][11] = getViewByIndex(i);
    		data[i][12] = getSpecialtyByIndex(i);
    		data[i][13] = getBrandByIndex(i);
    		data[i][14] = getStartLocationByIndex(i);
    		data[i][15] = getSearchAreaByIndex(i);
    		data[i][16] = getNameQueryByIndex(i);
    		data[i][17] = getVerifyListByIndex(i);
    	}
    	return data;
    }
	
}
