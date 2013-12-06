package hs.qa;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

public class MultiItems {

	private List<String> items;
	private String token = ",";
	
	public MultiItems() {
		items = new ArrayList<String>();
	}
	
	public void addString( String tokenizedString ) {
		items.add( tokenizedString.trim() );
	}

	public List<String> getItems() {
		return items;
	}

	public void setItems(List<String> items) {
		this.items = items;
	}
	
	public void reset() {
		items = null;
		items = new ArrayList<String>();
	}
	
	public String toString() {		
		return StringUtils.join( items, token );
	}
	
}
