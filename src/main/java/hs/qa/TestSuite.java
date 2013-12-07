package hs.qa;

import java.util.ArrayList;
import java.util.List;

public class TestSuite {

    private String suiteName;
    private String sauceURL;
    private List<TestCase> tests = new ArrayList<TestCase>();

    public TestSuite( String sName, String sauceUrl ) {
        this.suiteName = sName;
        this.sauceURL = sauceUrl;
    }

    public void add(TestCase test) {
        tests.add( test );
    }
    
    public List<TestCase> getAllTests() {
        return tests;
    }
    
    public String getSauceURL() {
		return sauceURL;
	}

    public String getSuiteName() {
		return suiteName;
	}
    
    public TestCase getTestByIndex( int idx ) {
    	if ( idx > tests.size() || idx < 0 ) {
    		throw new IndexOutOfBoundsException("Index " + idx + " was beyond the range of " + tests.size() + " test cases." );
    	}
    	return tests.get( idx );
    }

	public TestCase getTestByName( String name ) {
    	boolean found = false;
    	String testName = "null";
    	TestCase test = null;
    	for ( TestCase tc: tests ) {
    		testName = tc.getName();
    		if ( testName.equalsIgnoreCase( name ) ) {
    			found = true;
    			test = tc;
    			break;
    		}
    	}
    	if ( found == false ) {
    		return null;
    	} else {
    		System.out.println("Found test by its name: " + testName );
    		return test;
    	}
    }

	public int size() {
		return tests.size();    	
    }

}
