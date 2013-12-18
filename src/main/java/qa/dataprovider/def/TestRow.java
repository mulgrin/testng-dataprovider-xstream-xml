package qa.dataprovider.def;

import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("test")
public class TestRow {

	private TestArguments rowArgs;
	
    public TestRow( TestArguments testargs ) {
        setTestArgs( testargs );
        System.out.println();
    }    

	public TestArguments getTestArgs() {
		return rowArgs;
	}

	public void setTestArgs( TestArguments list ) {
		rowArgs = list;
	}

}
