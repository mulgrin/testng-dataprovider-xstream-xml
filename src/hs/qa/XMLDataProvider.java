package hs.qa;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import com.thoughtworks.xstream.XStream;

public class XMLDataProvider {
	
	public TestSuite ts;
	
	public static void main( String[] args) {
		new XMLDataProvider("input.xml");
	}
	
	public XMLDataProvider( String fileName ) {		
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
    		Object readObject = xStream.fromXML( new File("input.xml") );
    		ts = (TestSuite)readObject;
        }
		printSuite();
	}
	
	public String getTestNameByIndex( int idx ) {
		return ts.getAllTests().get( idx ).getName();
	}
	
	public List<String> getVerifyListByIndex( int idx ) {		
		return ts.getTestByIndex( idx ).getVerifyList();	
	}
	
	public Boolean getEnabledByIndex( int idx ) {
		return ts.getTestByIndex( idx ).getEnabled();
	}
	
	public void printSuite() {
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

	private String getNameQueryByIndex( int idx ) {
		return ts.getTestByIndex(idx).getNameQuery();
	}

	private String getSearchAreaByIndex( int idx ) {
		return ts.getTestByIndex(idx).getSearchArea();
	}

	private String getStartLocationByIndex( int idx ) {
		return ts.getTestByIndex(idx).getStartingLocation();
	}

	private String getBrandByIndex( int idx ) {
		return ts.getTestByIndex(idx).getBrand();
	}

	private String getSpecialtyByIndex( int idx ) {
		return ts.getTestByIndex(idx).getSpecialty();
	}

	private String getViewByIndex( int idx ) {
		return ts.getTestByIndex(idx).getView();
	}

	private String getRoleByIndex( int idx ) {
		return ts.getTestByIndex(idx).getRole();
	}

	private String getClientByIndex( int idx ) {
		return ts.getTestByIndex(idx).getClientIDP();
	}

	private String getEnvironmentByIndex( int idx ) {
		return ts.getTestByIndex(idx).getEnvironment();
	}

	private String getPasswordByIndex( int idx ) {
		return ts.getTestByIndex(idx).getPassWord();
	}

	private String getUsernameByIndex( int idx ) {
		return ts.getTestByIndex(idx).getUserName();
	}

	private String getAppUrlByIndex( int idx ) {
		return ts.getTestByIndex(idx).getAppUrl();
	}

	private String getBrowserByIndex( int idx ) {
		return ts.getTestByIndex(idx).getBrowser();
	}

	private String getLocaleByIndex( int idx ) {
		return ts.getTestByIndex(idx).getLocale();
	}

	private String getEnvFlagByIndex( int idx ) {
		return ts.getTestByIndex(idx).getEnvFlag();
	}

	public void createDefaultSuiteFile( File testXML ) {

        TestSuite mySuite = new TestSuite( "Test 1", "http://username-string:access-key-string@ondemand.saucelabs.com:80/wd/hub" );
        mySuite.add( new TestCase( true, "Test 1", "INTFED", "Grid", "Firefox", "http://google.com", "user1", "pass1", "Staging", 
        		"idp_test_psearch", "member", "New Window", "General Medicine", "South Carolina", "100 SW Market,Portland,OR,97201,US",
        		"Columbia,SC", "Parker, Peter", "Spiderman, Batman, Superman" ) );
        mySuite.add( new TestCase( true, "Test 2", "INTFED", "Grid", "Chrome", "http://google.com", "user2", "pass2", "Staging", 
        		"idp_test_psearch", "member", "New Window", "General Medicine", "South Carolina", "100 SW Market,Portland,OR,97201,US",
        		"Columbia,SC", "Pumpkin, Peter", "Spiderman, Batman, Wonder Woman") );
        XStream xstream = new XStream();
        xstream.alias("suite", TestSuite.class);
        xstream.alias("test", TestCase.class);
        String xml = xstream.toXML( mySuite );
        System.out.println( xml );
		FileWriter fw;
		try {
			fw = new FileWriter( testXML );
			fw.append( xml );
			fw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
