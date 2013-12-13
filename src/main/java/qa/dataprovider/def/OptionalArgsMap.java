package qa.dataprovider.def;

import java.util.Hashtable;
import java.util.LinkedHashMap;
import java.util.Map;

import com.google.common.base.Joiner;

public class OptionalArgsMap {

	private Map<String, Object> argsWrapper = new LinkedHashMap<String, Object>();
	
	public OptionalArgsMap() {
		setOptArgs( new Hashtable<String, Object>() );
	}
	
	public OptionalArgsMap( Map<String, Object> oa1 ) {
		setOptArgs( oa1 );
		System.out.println("Optional args are set to: " + this.toString() );
	}
	
	public void addStringArg( String propName, String propArg ) {
		System.out.println("Adding optional test property named " + propName + " with value " + propArg );
		argsWrapper.put( propName, propArg );
		System.out.println("Optional arguments size is now: " + this.size() );
	}
	
	public void addIntArg( String propName, Integer aInt ) {
		System.out.println("Adding optional test property named " + propName + " with value " + aInt );
		argsWrapper.put( propName, aInt );
		System.out.println("Optional arguments size is now: " + this.size() );
	}

	public Map<String, Object> getOptArgs() {
		return argsWrapper;
	}

	public void setOptArgs( Map<String, Object> oa1 ) {
		argsWrapper = oa1;
	}
	
	public void reset() {
		argsWrapper = null; // garbage collect
		argsWrapper = new Hashtable<String, Object>();
	}
	
	public int size() {
		return argsWrapper.size();
	}
	
	public String toString() {		
		Joiner.MapJoiner joiner = Joiner.on(",").withKeyValueSeparator("=");
		return joiner.join(argsWrapper);
	}

	public Object getArgByName( String name ) {
		return argsWrapper.get( name );
	}
	
}
