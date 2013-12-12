package qa.dataprovider.def;

public class TestCase {

	private RequiredArgs reqArgs;
	private OptionalArgs optArgs;
	
    public TestCase( RequiredArgs reqs, OptionalArgs opts ) {
        this.setReqArgs( reqs );
        this.setOptArgs( opts );
    }    

	public RequiredArgs getReqArgs() {
		return reqArgs;
	}
	
	public OptionalArgs getOptArgs() {
		return optArgs;
	}

	public void setReqArgs( RequiredArgs reqs ) {
		this.reqArgs = reqs;
	}
    
    private void setOptArgs( OptionalArgs opts ) {
    	this.optArgs = opts;		
	}

}
