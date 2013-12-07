package hs.qa;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import com.thoughtworks.xstream.XStream;

public class XMLTestDataProvider {
	
	private TestSuite ts;

	public XMLTestDataProvider( String fileName ) {		
		File testXML = new File( fileName );
        if ( !testXML.exists() ) {
        	try {
				testXML.createNewFile();
				createDefaultSuiteFile( testXML );
			} catch (IOException e) {
				e.printStackTrace();
			}
        } else {
        	System.out.println("Suite file already exists.  Loading test contents...\n");
        	XStream xStream = new XStream();
    		xStream.alias("suite", TestSuite.class);
            xStream.alias("test", TestCase.class);
    		xStream.processAnnotations(TestSuite.class);
    		xStream.processAnnotations(TestCase.class);
    		xStream.processAnnotations(MultiItems.class);
    		Object readObject = xStream.fromXML( testXML );
    		ts = (TestSuite)readObject;
        }
		printSuiteVertical();
	}	
	
	public void createDefaultSuiteFile( File testXML ) 
	{
        TestSuite mySuite = new TestSuite( "Test 1", "http://username-string:access-key-string@ondemand.saucelabs.com:80/wd/hub" );
        mySuite.add( new TestCase( true, "Test 1", "portal1", "Grid", "Firefox", "http://mywebsite.com", "user1", "pass1", "Staging", 
        		"test1", "member", "New Window", "Extraterrestrial Biology", "Texas", "12345 Main St., Cheyenne, WY, 82001, US",
        		"Columbia, SC", "Parker, Peter", "Spiderman, Batman, Superman" ) );
        mySuite.add( new TestCase( true, "Test 2", "portal2", "Local", "Chrome", "http://mywebsite.com", "user2", "pass2", "Staging", 
        		"test2", "federated", "New Window", "Extraterrestrial Biology", "Texas", "12345 Main St., Cheyenne, WY, 82001, US",
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
		ts = mySuite;
	}
	
	private String getAppUrlByIndex( int idx ) {
		return ts.getTestByIndex(idx).getAppUrl();
	}
	
	private String getBrandByIndex( int idx ) {
		return ts.getTestByIndex(idx).getBrand();
	}
	
	private String getBrowserByIndex( int idx ) {
		return ts.getTestByIndex(idx).getBrowser();
	}
	
	private String getClientByIndex( int idx ) {
		return ts.getTestByIndex(idx).getClientIDP();
	}

	public Boolean getEnabledByIndex( int idx ) {
		return ts.getTestByIndex( idx ).getEnabled();
	}

	private String getEnvFlagByIndex( int idx ) {
		return ts.getTestByIndex(idx).getEnvFlag();
	}

	private String getEnvironmentByIndex( int idx ) {
		return ts.getTestByIndex(idx).getEnvironment();
	}

	private String getLocaleByIndex( int idx ) {
		return ts.getTestByIndex(idx).getLocale();
	}

	private String getNameQueryByIndex( int idx ) {
		return ts.getTestByIndex(idx).getNameQuery();
	}

	private String getPasswordByIndex( int idx ) {
		return ts.getTestByIndex(idx).getPassWord();
	}

	private String getRoleByIndex( int idx ) {
		return ts.getTestByIndex(idx).getRole();
	}

	private String getSearchAreaByIndex( int idx ) {
		return ts.getTestByIndex(idx).getSearchArea();
	}

	private String getSpecialtyByIndex( int idx ) {
		return ts.getTestByIndex(idx).getSpecialty();
	}

	private String getStartLocationByIndex( int idx ) {
		return ts.getTestByIndex(idx).getStartingLocation();
	}

	public String getTestNameByIndex( int idx ) {
		return ts.getAllTests().get( idx ).getName();
	}

	private String getUsernameByIndex( int idx ) {
		return ts.getTestByIndex(idx).getUserName();
	}

	public List<String> getVerifyListByIndex( int idx ) {		
		return ts.getTestByIndex( idx ).getVerifyList();	
	}

	private String getViewByIndex( int idx ) {
		return ts.getTestByIndex(idx).getView();
	}

	public void printSuiteVertical() {
		System.out.println("Suite:\n---------------");
		System.out.println("SauceLabs URL: " + ts.getSauceURL() );
		for ( int i = 0; i < ts.size(); i++ ) {
			System.out.println("---------------");
			System.out.println("Enabled: " + getEnabledByIndex(i) );
			System.out.println("Test name: " + getTestNameByIndex(i) );
			System.out.println("Flag: " + getEnvFlagByIndex(i) );
			System.out.println("Locale: " + getLocaleByIndex(i) );
			System.out.println("Browser: " + getBrowserByIndex(i) );
			System.out.println("App URL: " + getAppUrlByIndex(i) );
			System.out.println("Username: " + getUsernameByIndex(i) );
			System.out.println("Password: " + getPasswordByIndex(i) );
			System.out.println("Environment: " + getEnvironmentByIndex(i) );
			System.out.println("Client: " + getClientByIndex(i) );
			System.out.println("Role: " + getRoleByIndex(i) );
			System.out.println("View: " + getViewByIndex(i) );
			System.out.println("Specialty: " + getSpecialtyByIndex(i) );
			System.out.println("Brand: " + getBrandByIndex(i) );
			System.out.println("Start location: " + getStartLocationByIndex(i) );
			System.out.println("Search area: " + getSearchAreaByIndex(i) );
			System.out.println("Name query: " + getNameQueryByIndex(i) );
			List<String> lst = getVerifyListByIndex(i);
			System.out.println("Verify list: " + StringUtils.join( lst, "," ) );
		}
		System.out.println("---------------\n");
	}	

	/**
	 * This is the TestNG DataProvider implementation
	 * Should return an Object[][] or Iterator<Object[]> data type
	 * @return
	 */
    public Object[][] getEighteenColumnData() {
    	Object[][] data = new Object[ts.size()][2];
    	for ( int i = 0; i < ts.size(); i++ ) {
    		data[i][0] = getEnabledByIndex(i);
    		data[i][1] = getTestNameByIndex(i);
    		// more to add
    	}
    	return data;
    }
	
}
