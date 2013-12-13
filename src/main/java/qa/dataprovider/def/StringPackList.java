package qa.dataprovider.def;

import java.util.ArrayList;
import java.util.List;
import org.apache.commons.lang3.StringUtils;

/**
 * A pack of strings sent as a single argument to a test.
 */
public class StringPackList {

	private List<String> pack;
	private String token = ",";
	
	public StringPackList() {
		pack = new ArrayList<String>();
	}
	
	public void addString( String tokenizedString ) {
		pack.add( tokenizedString.trim() );
	}

	public List<String> getPack() {
		return pack;
	}

	public void setPack(List<String> items) {
		this.pack = items;
	}
	
	public void reset() {
		pack = null;
		pack = new ArrayList<String>();
	}
	
	public String toString() {		
		return StringUtils.join( pack, token );
	}
	
}
