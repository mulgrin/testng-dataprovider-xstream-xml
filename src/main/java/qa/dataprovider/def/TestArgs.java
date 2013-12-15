package qa.dataprovider.def;

import java.util.ArrayList;
import java.util.List;
import org.apache.commons.lang3.StringUtils;

public class TestArgs {
	
	private List<String[]> argsWrapper; 
	
	public TestArgs() {
		System.out.println("New TestArgs object with default required arguments.");
		reset();
	}
	
	public TestArgs( String en, String name, String env, String locale, String browser ) {
		setEnabled( en );
		setTestName( name );
		setEnvironment( env );
		setTestLocale( locale );
		setBrowser( browser );
		System.out.println("Required args are set to: " + this.toString() );
	}

	public List<String[]> getAllTestArguments() {
		return argsWrapper;
	}
	
	public String getRawTestArguments() {
		List<String> list = new ArrayList<String>();
		for ( String[] x : argsWrapper ) {
			list.add( x[2] );
		}
		return StringUtils.join( list, "," );
	}

	public void setTestArguments( List<String[]> lo ) {
		argsWrapper = lo;
	}
	
	public void reset() {
		argsWrapper = null; // garbage collect
		setTestArguments( new ArrayList<String[]>() );
		setEnabled( "false" );
		setTestName( "default" );
		setEnvironment( "development" );
		setTestLocale( "Grid" ); // or Local
		setBrowser( "Firefox" );
	}
	
	public int testSize() {
		return argsWrapper.size();
	}
	
	public String toString() {
		StringBuilder returnVal = new StringBuilder("[ ");
		for ( String[] x : argsWrapper ) {
			returnVal.append("{ ");
			returnVal.append( StringUtils.join(x) );
			returnVal.append(" },\n");
		}
		returnVal.append(" ]\n");
		return returnVal.toString();
	}	

	/* Helpers to get values from test arguments. */

	public Boolean getEnabled() {
		String[] val = argsWrapper.get(0);
		if ( val[1].equalsIgnoreCase("java.lang.Boolean") || val[1].equalsIgnoreCase("java.lang.boolean") ) {
		    return Boolean.valueOf( val[2] );
		} else {
			throw new IllegalArgumentException("The variable 'enabled' must be a string.");
		}
	}

	public String getTestName() {
		String[] val = argsWrapper.get(1);
		if ( val[1].equalsIgnoreCase("java.lang.String") ) {
		    return (String)val[2];
		} else {
			throw new IllegalArgumentException("The variable '" + val[0] + "' must be a " + val[1] + ".");
		}
	}
	
	public String getEnvironment() {
		String[] val = argsWrapper.get(2);
		if ( val[1].equalsIgnoreCase("java.lang.String") ) {
		    return (String)val[2];
		} else {
			throw new IllegalArgumentException("The variable '" + val[0] + "' must be a " + val[1] + ".");
		}
	}
    
    public String getTestLocale() {
    	String[] val = argsWrapper.get(3);
		if ( val[1].equalsIgnoreCase("java.lang.String") ) {
		    return (String)val[2];
		} else {
			throw new IllegalArgumentException("The variable '" + val[0] + "' must be a " + val[1] + ".");
		}
	}    

	public String getBrowser() {
		String[] val = argsWrapper.get(4);
		if ( val[1].equalsIgnoreCase("java.lang.String") ) {
		    return (String)val[2];
		} else {
			throw new IllegalArgumentException("The variable '" + val[0] + "' must be a " + val[1] + ".");
		}
    }
	
	/* Helpers to set test argument values */
	
	public void setEnabled( String enabled ) {
		String[] val = new String[3];
		val[0] = "environment";
		val[1] = "java.lang.Boolean";
		String en;
		if ( enabled.equalsIgnoreCase("true") || enabled.equalsIgnoreCase("Y") ) {
			en = "true";
		} else if ( enabled.equalsIgnoreCase("false") || enabled.equalsIgnoreCase("N") ) {
			en = "false";
		} else {
			throw new IllegalArgumentException("The variable '" + val[0] + "' must be a " + val[1] + " or a valid value.");
		}
		val[2] = en;
		argsWrapper.set(0, val );
	}

	public void setTestName( String testName ) {
		String[] val = new String[3];
		val[0] = "testname";
		val[1] = "java.lang.String";
		val[2] = testName;
		argsWrapper.set(1, val );
	}	

	public void setEnvironment( String env ) {
		String[] val = new String[3];
		val[0] = "environment";
		val[1] = "java.lang.String";
		val[2] = env;
		argsWrapper.set(2, val );
	}

	public void setTestLocale( String testLocale ) {
		String[] val = new String[3];
		val[0] = "testlocale";
		val[1] = "java.lang.String";
		val[2] = testLocale;
		argsWrapper.set(3, val );
	}
	
	public void setBrowser( String browser ) {
		String[] val = new String[3];
		val[0] = "browser";
		val[1] = "java.lang.String";
		val[2] = browser;
		argsWrapper.set(4, val );
	}
	
	public void addTestArgument( String propName, String type, String propVal ) {
		System.out.println("Adding optional test property named " + propName + " with value " + propVal );
		String[] val = new String[3];
		val[0] = propName;
		val[1] = type;
		val[2] = propVal;
		for ( String[] x : argsWrapper ) {
			if ( x[0].equalsIgnoreCase( propName ) ) {
				throw new IllegalArgumentException("Failed to add test argument.");
			}
		}		
		argsWrapper.add( val );
		System.out.println("Optional arguments size is now: " + this.testSize() );
	}

}
