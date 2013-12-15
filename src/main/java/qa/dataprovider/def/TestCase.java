package qa.dataprovider.def;


public class TestCase {

	private TestArgs testArgs;
	
    public TestCase( TestArgs testargs ) {
        setTestArgs( testargs );
        System.out.println();
    }    

	public TestArgs getTestArgs() {
		return testArgs;
	}

	public void setTestArgs( TestArgs list ) {
		testArgs = list;
	}

}
