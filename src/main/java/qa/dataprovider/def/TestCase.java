package qa.dataprovider.def;

public class TestCase {

	private RequiredArgsList reqArgs;
	private OptionalArgsMap optArgs;
	
    public TestCase( RequiredArgsList reqs, OptionalArgsMap opts ) {
        this.setReqArgs( reqs );
        this.setOptArgs( opts );
    }    

	public RequiredArgsList getReqArgs() {
		return reqArgs;
	}
	
	public OptionalArgsMap getOptArgs() {
		return optArgs;
	}

	public void setReqArgs( RequiredArgsList reqs ) {
		this.reqArgs = reqs;
	}
    
    private void setOptArgs( OptionalArgsMap opts ) {
    	this.optArgs = opts;		
	}

}
