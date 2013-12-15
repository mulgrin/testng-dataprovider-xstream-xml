package qa.dataprovider.def;

import java.util.ArrayList;
import java.util.List;
import org.apache.commons.lang3.StringUtils;

/**
 * A pack of strings sent as a single argument to a test.
 */
public class StringList {

	private List<String> list;
	
	public StringList() {
		list = new ArrayList<String>();
	}
	
	public void addString( String tokenizedString ) {
		list.add( tokenizedString.trim() );
	}

	public List<String> getPack() {
		return list;
	}

	public void setPack(List<String> items) {
		list = items;
	}
	
	public void reset() {
		list = null;
		list = new ArrayList<String>();
	}
	
	public String toString() {		
		return StringUtils.join( list, "," );
	}
	
}
