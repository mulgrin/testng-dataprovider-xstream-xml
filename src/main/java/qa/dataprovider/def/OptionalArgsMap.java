package qa.dataprovider.def;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;
import com.google.common.base.Joiner;

public class OptionalArgsMap {

	private Map<String, Object> argsWrapper = new HashMap<String, Object>();
    private String token = ",";
	
	public OptionalArgsMap() {
		setOptArgs( new Hashtable<String, Object>() );
	}
	
	public OptionalArgsMap( Map<String, Object> oa1 ) {
		setOptArgs( oa1 );
		System.out.println("Optional args are set to: " + this.toString() );
	}
	
	public void addStringArg( String propName, String propArg ) {
		System.out.println("Adding optional test property named " + propName + " with value " + propArg );
		this.argsWrapper.put( propName, propArg );
		System.out.println("Optional arguments size is now: " + this.size() );
	}
	
	public void addIntArg( String propName, Integer aInt ) {
		System.out.println("Adding optional test property named " + propName + " with value " + aInt );
		this.argsWrapper.put( propName, aInt );
		System.out.println("Optional arguments size is now: " + this.size() );
	}

	public Map<String, Object> getOptArgs() {
		return argsWrapper;
	}

	public void setOptArgs( Map<String, Object> oa1 ) {
		this.argsWrapper = oa1;
	}
	
	public void reset() {
		this.argsWrapper = null; // garbage collect
		this.argsWrapper = new Hashtable<String, Object>();
	}
	
	public int size() {
		return this.argsWrapper.size();
	}
	
	public String toString() {		
		Joiner.MapJoiner joiner = Joiner.on(token).withKeyValueSeparator("=");
		return joiner.join(argsWrapper);
	}

	public Object getArgByIndex( int propIdx ) {
		return this.argsWrapper.get( propIdx );
	}
	
}
