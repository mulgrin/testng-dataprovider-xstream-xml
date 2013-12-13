package qa.dataprovider;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import qa.dataprovider.def.OptionalArgsMap;
import qa.dataprovider.def.RequiredArgsList;
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
            xStream.alias( "reqs", RequiredArgsList.class );
            xStream.alias( "opts", OptionalArgsMap.class );
            xStream.autodetectAnnotations(true);
    		//xStream.processAnnotations(TestSuite.class);
    		//xStream.processAnnotations(TestCase.class);
    		//xStream.processAnnotations(StringPackList.class);
    		//xStream.processAnnotations(RequiredArgsList.class);
    		//xStream.processAnnotations(OptionalArgsMap.class);
    		Object readObject = xStream.fromXML( testXML );
    		testSuite = (TestSuite)readObject;
        }
	}	
	
	public void createDefaultSuiteFile( File testXML ) 
	{
        TestSuite mySuite = new TestSuite( "Suite 1", "http://username-string:access-key-string@ondemand.saucelabs.com:80/wd/hub" );
        
        List<String> heroes1 = new ArrayList<String>();
        heroes1.add("Wolverine");
        heroes1.add("Batman");
        heroes1.add("Superman");
        
        Map<String, Object> oa1 = new HashMap<String, Object>();
        oa1.put( "url", "http://mywebsite1.com" );
        oa1.put( "username", "user1" );
        oa1.put( "password", "pass1" );
        oa1.put( "verifies", heroes1 );
        oa1.put( "aNumber", new Double(99.99) );
        
        mySuite.add( new TestCase( new RequiredArgsList( true, "Test 1", "portal1", "Grid", "Firefox" ), new OptionalArgsMap( oa1 ) ) );
        
        List<String> heroes2 = new ArrayList<String>();
        heroes2.add("Silver Surfer");
        heroes2.add("Colossus");
        heroes2.add("Phoenix");
        
        Map<String, Object> oa2 = new HashMap<String, Object>();
        oa2.put( "url", "http://mywebsite1.com" );
        oa2.put( "username", "user1" );
        oa2.put( "password", "pass1" );
        oa2.put( "verifies", heroes2 );
        oa2.put( "aNumber", new Integer(99) );
        mySuite.add( new TestCase ( new RequiredArgsList( true, "Test 2", "portal2", "Grid", "Firefox" ), new OptionalArgsMap( oa2 ) ) );
        
        XStream xstream = new XStream();
        xstream.alias( "suite", TestSuite.class );
        xstream.alias( "test", TestCase.class );
        xstream.alias( "required", RequiredArgsList.class );
        xstream.alias( "optional", OptionalArgsMap.class );
        //xstream.addImplicitCollection( RequiredArgsList.class, "argsWrapper" );
        //xstream.addImplicitMap( OptionalArgsMap.class, "argsWrapper", "opts", Object.class, "argKey" );
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
		return this.getReqArgs(idx).getBrowser();
	}

	public Boolean getEnabledByIndex( int idx ) {
		return this.getReqArgs(idx).getEnabled();
	}

	public String getEnvironmentByIndex( int idx ) {
		return this.getReqArgs(idx).getEnvironment();
	}

	public String getTestLocaleByIndex( int idx ) {
		return this.getReqArgs(idx).getTestLocale();
	}

	public String getTestNameByIndex( int idx ) {
		return this.getReqArgs(idx).getTestName();
	}

	/**
	 * This is a TestNG DataProvider implementation
	 * Should return an Object[][] or Iterator<Object[]> data type
	 * @return
	 */
    public Object[][] getCompactData() { 
    	Object[][] array = new Object[testSuite.size()][2];
    	for ( int i = 0; i < testSuite.size(); i++ ) {
    		RequiredArgsList reqa = getReqArgs(i);
    		array[i][0] = reqa;
        	OptionalArgsMap opta = getOptArgs(i);
        	array[i][1] = opta;
    	}
    	System.out.println("Input array size is: " + array.length + " x " + array[0].length );
    	return array;
    }
    
	private RequiredArgsList getReqArgs( int testIdx ) {
		return testSuite.getAllTests().get( testIdx ).getReqArgs();
	}
	
	private OptionalArgsMap getOptArgs( int testIdx ) {		
		return testSuite.getAllTests().get( testIdx ).getOptArgs();
	}
	
}
