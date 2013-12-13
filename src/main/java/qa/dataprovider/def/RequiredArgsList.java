package qa.dataprovider.def;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

public class RequiredArgsList {
	
	private List<Object> argsWrapper;
	//private Boolean enabled;
	//private String testName;
	//private String environment;
	//private String testLocale; // grid or local
	//private String browser;
	
	public RequiredArgsList() {
		setReqArgs( new ArrayList<Object>() );
		for ( int i = 0; i < 5; i++ ) {
			argsWrapper.set(i, "nUll");
		}
	}
	
	public RequiredArgsList( Boolean en, String name, String env, String locale, String browser ) {
		List<Object> lo = new ArrayList<Object>();
		lo.add( en );
		//this.enabled = en;
		lo.add( name );
		//this.testName = name;
		lo.add( env );
		//this.environment = env;
		lo.add( locale );
		//this.testLocale = locale;
		lo.add( browser );
		//this.browser = browser;
		setReqArgs( lo );
		System.out.println("Required args are set to: " + this.toString() );
	}

	public List<Object> getReqArgs() {
		return argsWrapper;
	}

	public void setReqArgs( List<Object> reqArgs ) {
		this.argsWrapper = reqArgs;
	}
	
	public void reset() {
		this.argsWrapper = null; // garbage collect
		this.argsWrapper = new ArrayList<Object>();
		for ( int i = 0; i < 5; i++ ) {
			argsWrapper.set(i, "nUll");
		}
	}
	
	public int size() {
		return this.argsWrapper.size();
	}
	
	public String toString() {
	    return StringUtils.join( this.argsWrapper, "," );
	}	

	public String getBrowser() {
        return (String) argsWrapper.get(4);
    }

	public Boolean getEnabled() {
		return (Boolean) argsWrapper.get(0);
	}

	public String getTestName() {
		return (String) argsWrapper.get(1);
	}
    
    public String getTestLocale() {
		return (String) argsWrapper.get(3);
	}

	public void setTestName( String testName ) {
		argsWrapper.set(1, testName );
	}

	public void setTestLocale( String testLocale ) {
		argsWrapper.set(3, testLocale );
	}
	
	public void setEnabled( Boolean enabled ) {
		argsWrapper.set(0, enabled );
	}

	public void setEnvironment( String env ) {
		argsWrapper.set(2, env );
	}
	
	public void setBrowser( String browser ) {
		argsWrapper.set(4, browser );
	}

	public String getEnvironment() {
		return (String) argsWrapper.get(2);
	}

}
