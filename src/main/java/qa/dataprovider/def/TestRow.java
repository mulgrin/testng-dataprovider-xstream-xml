package qa.dataprovider.def;

import java.util.ArrayList;
import java.util.List;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamImplicit;

@XStreamAlias("test")
public class TestRow {

	@XStreamImplicit
	private List<TestArguments> rowArgs = new ArrayList<TestArguments>();
	
    public TestRow( TestArguments testargs ) {
        setTestArgs( testargs );
        System.out.println();
    }    

	public TestArguments getTestArgs() {
		return rowArgs.get(0);
	}

	public void setTestArgs( TestArguments list ) {
		if ( rowArgs.size() == 0 ) {
			rowArgs.add( list );
		} else {
		    rowArgs.set( 0,  list );
	    }
	}

}
