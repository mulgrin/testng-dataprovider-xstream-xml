package qa.dataprovider.def;

public class TestRow {

	private TestArguments testArgs;
	
    public TestRow( TestArguments testargs ) {
        setTestArgs( testargs );
        System.out.println();
    }    

	public TestArguments getTestArgs() {
		return testArgs;
	}

	public void setTestArgs( TestArguments list ) {
		testArgs = list;
	}

}
