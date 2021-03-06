package qa.dataprovider.def;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamConverter;

/** A node value that should look like this.
 *  <key type="string value">val</key>
 */

@XStreamAlias("arg")
@XStreamConverter(value=ArgConverter.class)
public class ArgObject {
	
	private String key;	
	private String val;
	private String type; // attribute

	public ArgObject( String key, String type, String val ) {
		this.key = key;
		this.type = type;
		this.val = val;
	}

	public String toString() {
		return getKey() + " [" + getType() + "]: " + getVal();
	}
	
	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getVal() {
		return val;
	}

	public void setVal(String val) {
		this.val = val;
	}
	
}
