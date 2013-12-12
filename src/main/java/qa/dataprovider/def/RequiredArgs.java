package qa.dataprovider.def;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

public class RequiredArgs implements Iterable<Object> {
	
	private List<Object> argsWrapper;
	private String token = ",";
	
	private Boolean enabled;
	private String testName;
	private String environment;
	private String testLocale;
	private String browser;
	
	public RequiredArgs() {
		setReqArgs( new ArrayList<Object>() );
	}
	
	public RequiredArgs( Boolean en, String name, String env, String locale, String browser ) {
		List<Object> lo = new ArrayList<Object>();
		lo.add( en );
		lo.add( name );
		lo.add( env );
		lo.add( locale );
		lo.add( browser );
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
	}
	
	public int size() {
		return this.argsWrapper.size();
	}
	
	public String toString() {		
		return StringUtils.join( this.argsWrapper, token );
	}	

	public String getBrowser() {
        return browser;
    }

	public Boolean getEnabled() {
		return enabled;
	}

	public String getTestName() {
		return testName;
	}
    
    public String getTestLocale() {
		return testLocale;
	}

	public void setTestName( String testName ) {
		this.testName = testName;
	}

	public void setTestLocale( String locale ) {
		this.testLocale = locale;
	}
	
	public void setEnabled( Boolean enabled ) {
		this.enabled = enabled;
	}

	public void setEnvironment( String env ) {
		this.environment = env;
	}
	
	public void setBrowser( String browser ) {
		this.browser = browser;
	}

	public String getEnvironment() {
		return environment;
	}

	@Override
	public Iterator<Object> iterator() {
		Iterator<Object> ireq = argsWrapper.iterator();
		return ireq;
	}	

}
