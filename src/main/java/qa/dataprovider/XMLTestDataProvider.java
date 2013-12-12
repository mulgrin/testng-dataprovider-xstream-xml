package qa.dataprovider;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import net.entropysoft.transmorph.ConverterException;
import net.entropysoft.transmorph.DefaultConverters;
import net.entropysoft.transmorph.Transmorph;
import qa.dataprovider.def.OptionalArgs;
import qa.dataprovider.def.RequiredArgs;
import qa.dataprovider.def.StringPack;
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
            xStream.alias( "reqs", RequiredArgs.class );
            xStream.alias( "opts", OptionalArgs.class );
    		xStream.processAnnotations(TestSuite.class);
    		xStream.processAnnotations(TestCase.class);
    		xStream.processAnnotations(StringPack.class);
    		xStream.processAnnotations(RequiredArgs.class);
    		xStream.processAnnotations(OptionalArgs.class);
    		Object readObject = xStream.fromXML( testXML );
    		testSuite = (TestSuite)readObject;
        }
	}	
	
	public void createDefaultSuiteFile( File testXML ) 
	{
        TestSuite mySuite = new TestSuite( "Test 1", "http://username-string:access-key-string@ondemand.saucelabs.com:80/wd/hub" );
        
        mySuite.add( new RequiredArgs( true, "Test 1", "portal1", "Grid", "Firefox" ), new OptionalArgs( "http://mywebsite1.com", 
        		"user1", "pass1", "Staging", "test1", "member", "New Window", "Biology", "Texas", "12345 Main St., Cheyenne, WY, 82001, US",
        		"Columbia, SC", "Parker, Peter", "Wolverine, Batman, Superman" ) );
        
        mySuite.add( new RequiredArgs( true, "Test 2", "portal2", "Grid", "Firefox" ), new OptionalArgs( "http://mywebsite2.com", 
        		"user2", "pass2", "Production", "test1", "federated", "New Window", "Biology", "Texas", "67890 Minor St., Cheyenne, WY, 82001, US",
        		"New York, NY", "Doe, John", "Silver Surfer, Robin, Thing" ) );
        
        XStream xstream = new XStream();
        xstream.alias( "suite", TestSuite.class );
        xstream.alias( "test", TestCase.class );
        xstream.alias( "reqs", RequiredArgs.class );
        xstream.alias( "opts", OptionalArgs.class );
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
    		RequiredArgs reqa = getReqArgs(i);
    		array[i][0] = reqa;
        	OptionalArgs opta = getOptArgs(i);
        	array[i][1] = opta;
    	}
    	return array;
    }
    
	/**
	 * This is a TestNG DataProvider implementation
	 * Should return an Object[][] or Iterator<Object[]> data type
	 * @return
	 */
    public Object[][] getAllRowsInOneArray() {    	
    	List<Object> lo = new ArrayList<Object>();
    	for ( int i = 0; i < testSuite.size(); i++ ) {
    		RequiredArgs reqa = getReqArgs(i);
        	OptionalArgs opta = getOptArgs(i);
        	for ( Object m: reqa ) {
        		lo.add( m );
        	}
        	for ( Object p: opta ) {
        		lo.add( p );
        	}
    	}
    	Transmorph transmorph = new Transmorph( new DefaultConverters() );
    	Object[][] array = null;
		try {
			array = transmorph.convert( lo, Object[][].class);
		} catch ( ConverterException e ) {
			e.printStackTrace();
		}
    	return array;
    }

	private RequiredArgs getReqArgs( int testIdx ) {
		return testSuite.getAllTests().get( testIdx ).getReqArgs();
	}
	
	private OptionalArgs getOptArgs( int testIdx ) {		
		return testSuite.getAllTests().get( testIdx ).getOptArgs();
	}
	
}
