package qa.dataprovider;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import qa.dataprovider.def.OptionalArgsMap;
import qa.dataprovider.def.TestArgs;
import qa.dataprovider.def.TestCase;
import qa.dataprovider.def.TestSuite;

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
            xStream.alias( "args", TestArgs.class );
            xStream.autodetectAnnotations(true);
    		Object readObject = xStream.fromXML( testXML );
    		testSuite = (TestSuite)readObject;
        }
	}	
	
	public void createDefaultSuiteFile( File testXML ) 
	{
        TestSuite mySuite = new TestSuite( "Suite 1", "http://username-string:access-key-string@ondemand.saucelabs.com:80/wd/hub" );
        
        TestArgs tArgs1 = new TestArgs( "true", "Test 1", "portal1", "Grid", "Firefox" );
        tArgs1.addTestArgument( "url", "java.lang.String", "http://google.com" );
        TestCase tCase1 = new TestCase( tArgs1 );
        mySuite.add( tCase1 );
        
        TestArgs tArgs2 = new TestArgs( "true", "Test 2", "portal2", "Local", "Chrome" );
        tArgs2.addTestArgument( "url", "java.lang.String", "http://yelp.com" );
        TestCase tCase2 = new TestCase( tArgs2 );
        mySuite.add( tCase2 );
        
        XStream xstream = new XStream();
        xstream.alias( "suite", TestSuite.class );
        xstream.alias( "test", TestCase.class );
        xstream.alias( "args", TestArgs.class );
        xstream.autodetectAnnotations(true);
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
	
	public String getBrowserByIndex( int idx ) {
		return this.getTestArgsByIndex(idx).getBrowser();
	}

	public Boolean getEnabledByIndex( int idx ) {
		return this.getTestArgsByIndex(idx).getEnabled();
	}

	public String getEnvironmentByIndex( int idx ) {
		return this.getTestArgsByIndex(idx).getEnvironment();
	}

	public String getTestLocaleByIndex( int idx ) {
		return this.getTestArgsByIndex(idx).getTestLocale();
	}

	public String getTestNameByIndex( int idx ) {
		return this.getTestArgsByIndex(idx).getTestName();
	}

	/**
	 * This is a TestNG DataProvider implementation
	 * Should return an Object[][] or Iterator<Object[]> data type
	 * @return
	 */
    public Object[][] getCompactData() { 
    	Object[][] array = new Object[testSuite.size()][2];
    	for ( int i = 0; i < testSuite.size(); i++ ) {
    		TestArgs targs = getTestArgsByIndex(i);
    		array[i][0] = targs.getRawTestArguments();
    	}
    	System.out.println("Input array size is: " + array.length + " x " + array[0].length );
    	return array;
    }
    
	private TestArgs getTestArgsByIndex( int testIdx ) {
		return testSuite.getAllTests().get( testIdx ).getTestArgs();
	}
	
}
