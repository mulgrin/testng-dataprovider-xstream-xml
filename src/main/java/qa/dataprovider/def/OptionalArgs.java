package qa.dataprovider.def;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

public class OptionalArgs implements Iterable<Object> {

    private List<Object> argsWrapper;
    private String token = ",";
	
	public OptionalArgs() {
		setOptArgs( new ArrayList<Object>() );
	}
	
	public OptionalArgs( Object... args ) {
		List<Object> lo = new ArrayList<Object>();
		for ( Object o : args ) {
			lo.add( o );
		}
		setOptArgs( lo );
		System.out.println("Optional args are set to: " + this.toString() );
	}
	
	public void addStringArg( String aString ) {
		System.out.println("Adding String to optional test arguments: " + aString );
		this.argsWrapper.add( aString.trim() );
		System.out.println("Optional arguments size is now: " + this.size() );
	}
	
	public void addIntArg( Integer aInt ) {
		System.out.println("Adding Integer to optional test arguments: " + aInt );
		this.argsWrapper.add( aInt );
		System.out.println("Optional arguments size is now: " + this.size() );
	}

	public List<Object> getOptArgs() {
		return argsWrapper;
	}

	public void setOptArgs( List<Object> reqArgs ) {
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

	public Object getArgByIndex( int propIdx ) {
		return this.argsWrapper.get( propIdx );
	}

	@Override
	public Iterator<Object> iterator() {
		Iterator<Object> iopt = argsWrapper.iterator();
		return iopt;
	}
	
}
