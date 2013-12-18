package qa.dataprovider.def;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamImplicit;

@XStreamAlias("args")
public class TestArguments {
	
	@XStreamImplicit
	private List<ArgObject> argsWrapper = new ArrayList<ArgObject>(); 
	
	public TestArguments() {
		System.out.println("New TestArguments object with default required arguments.");
		reset();
	}
	
	public TestArguments( String en, String name, String env, String locale, String browser ) {
		System.out.println("Creating new TestArguments object...");
		setEnabled( en );
		setTestName( name );
		setEnvironment( env );
		setTestLocale( locale );
		setBrowser( browser );
		System.out.println("Required args are set to: " + this.toString() );
	}

	public List<ArgObject> getAllTestArguments() {
		return argsWrapper;
	}
	
	public String getRawTestArguments() {
		List<String> list = new ArrayList<String>();
		for ( ArgObject x : argsWrapper ) {
			list.add( x.getVal() );
		}
		return StringUtils.join( list, "," );
	}

	public void setTestArguments( List<ArgObject> lo ) {
		argsWrapper = lo;
	}
	
	public void reset() {
		argsWrapper = null; // garbage collect
		setTestArguments( new ArrayList<List<String>>() );
		setEnabled( "false" );
		setTestName( "default" );
		setEnvironment( "development" );
		setTestLocale( "Grid" ); // or Local
		setBrowser( "Firefox" );
	}
	
	private void setTestArguments(ArrayList<List<String>> arrayList) {
		// TODO Auto-generated method stub
		
	}

	public int testSize() {
		return argsWrapper.size();
	}
	
	public String toString() {
		String[] joined = new String[argsWrapper.size()];
		int count = 0;
		for ( ArgObject x : argsWrapper ) {
			String[] items = new String[3];
			items[0] = x.getKey();
			items[1] = x.getType();
			items[2] = x.getVal();
			joined[count] = "{" + StringUtils.join( items, ", " ) + "}";
			count++;
		}
		return "[" + StringUtils.join( joined, ", " ) + "]";
	}	

	/* Helpers to get values from test arguments. */

	public Boolean getEnabled() {
		ArgObject val = argsWrapper.get(0);
		if ( val.getType().equalsIgnoreCase("java.lang.Boolean") || val.getType().equalsIgnoreCase("java.lang.boolean") ) {
		    return Boolean.valueOf( val.getVal() );
		} else {
			throw new IllegalArgumentException("The variable 'enabled' must be a string.");
		}
	}

	public String getTestName() {
		ArgObject val = argsWrapper.get(1);
		if ( val.getType().equalsIgnoreCase("java.lang.String") ) {
		    return val.getVal();
		} else {
			throw new IllegalArgumentException("The variable '" + val.getKey() + "' must be a " + val.getType() + " for value '" + val.getVal() + "'.");
		}
	}
	
	public String getEnvironment() {
		ArgObject val = argsWrapper.get(2);
		if ( val.getType().equalsIgnoreCase("java.lang.String") ) {
		    return val.getVal();
		} else {
			throw new IllegalArgumentException("The variable '" + val.getKey() + "' must be a " + val.getType() + " for value '" + val.getVal() + "'.");
		}
	}
    
    public String getTestLocale() {
    	ArgObject val = argsWrapper.get(3);
		if ( val.getType().equalsIgnoreCase("java.lang.String") ) {
		    return val.getVal();
		} else {
			throw new IllegalArgumentException("The variable '" + val.getKey() + "' must be a " + val.getType() + " for value '" + val.getVal() + "'.");
		}
	}    

	public String getBrowser() {
		ArgObject val = argsWrapper.get(4);
		if ( val.getType().equalsIgnoreCase("java.lang.String") ) {
		    return val.getVal();
		} else {
			throw new IllegalArgumentException("The variable '" + val.getKey() + "' must be a " + val.getType() + " for value '" + val.getVal() + "'.");
		}
    }
	
	/* Helpers to set test argument values */
	
	public void setEnabled( String enabled ) {
		String en;
		if ( enabled.equalsIgnoreCase("true") || enabled.equalsIgnoreCase("Y") ) {
			en = "true";
		} else if ( enabled.equalsIgnoreCase("false") || enabled.equalsIgnoreCase("N") ) {
			en = "false";
		} else {
			throw new IllegalArgumentException("The variable '" + enabled + "' must be a valid Boolean value.");
		}
		ArgObject val = new ArgObject( "enabled", "java.lang.Boolean", en );
		if ( argsWrapper.size() < 1 ) {
			argsWrapper.add( 0, val );
		} else {
			argsWrapper.set( 0, val );
		}
		System.out.println("Set '" + val.getKey() + "' value at index 0 to '" + val.getVal() + "' with type of '" + val.getType() + "'." );
	}

	public void setTestName( String testName ) {
		ArgObject val = new ArgObject( "testname", "java.lang.String", testName );
		if ( argsWrapper.size() < 2 ) {
		    argsWrapper.add( 1, val );
		} else {
			argsWrapper.set( 1, val );
		}
		System.out.println("Set '" + val.getKey() + "' value at index 1 to '" + val.getVal() + "' with type of '" + val.getType() + "'." );
	}	

	public void setEnvironment( String env ) {
		ArgObject val = new ArgObject( "environment", "java.lang.String", env );
		if ( argsWrapper.size() < 3 ) {
		    argsWrapper.add( 2, val );
		} else {
			argsWrapper.set( 2, val );
		}
		System.out.println("Set '" + val.getKey() + "' value at index 2 to '" + val.getVal() + "' with type of '" + val.getType() + "'." );
	}

	public void setTestLocale( String testLocale ) {
		ArgObject val = new ArgObject( "testlocale", "java.lang.String", testLocale );
		if ( argsWrapper.size() < 4 ) {
		    argsWrapper.add( 3, val );
		} else {
			argsWrapper.set( 3, val );
		}
		System.out.println("Set '" + val.getKey() + "' value at index 3 to '" + val.getVal() + "' with type of '" + val.getType() + "'." );
	}
	
	public void setBrowser( String browser ) {
		ArgObject val = new ArgObject( "browser", "java.lang.String", browser );
		if ( argsWrapper.size() < 5 ) {
		    argsWrapper.add( 4, val );
		} else {
			argsWrapper.set( 4, val );
		}
		System.out.println("Set '" + val.getKey() + "' value at index 4 to '" + val.getVal() + "' with type of '" + val.getType() + "'." );
	}
	
	public void addTestArgument( String propName, String type, String propVal ) {
		System.out.println("Adding optional test property named '" + propName + "' with value of '" + propVal + "' and with type of '" + type + "'." );
		ArgObject val = new ArgObject( propName, type, propVal );
		int count = 0;
		for ( ArgObject x : argsWrapper ) {
			if ( x.getKey().equalsIgnoreCase( propName ) ) {
				throw new IllegalArgumentException("Failed to add test argument '" + x.getKey() + "'.  It already exists at index '" + count + "' with a value of '" + x.getVal() + "'." );
			}
			count++;
		}
		// if no error, go ahead and add it at the end
		argsWrapper.add( this.testSize(),  val );
		System.out.println("Test arguments size is now: " + this.testSize() );
	}

}
