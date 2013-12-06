package hs.qa;

import java.util.Arrays;
import java.util.List;

public class TestCase {

    private Boolean enabled;
	private String testName;
	private String envFlag;
	private String locale;
	private String browser;
	private String appUrl;
	private String userName;
	private String passWord;
	private String environment;
	private String clientIDP;
	private String role;
	private String view;
	private String specialty;
	private String brand;
	private String startingLocation;
	private String searchArea;
	private String nameQuery;
	private MultiItems verifyList;
	
    public TestCase( Boolean en, String name, String flag, String loc, String browser, 
    		String url, String user, String pass, String env, String client, 
    		String rol, String vw, String spec, String bra, String start, 
    		String area, String query, String list ) {
        this.setEnabled(en);
        this.setTestName(name);
        this.setEnvFlag(flag);
        this.setLocale(loc);
        this.setBrowser(browser);
        this.setAppUrl(url);
        this.setUserName(user);
        this.setPassWord(pass);
        this.setEnvironment(env);
        this.setClientIDP(client);
        this.setRole(rol);
        this.setView(vw);
        this.setSpecialty(spec);
        this.setBrand(bra);
        this.setStartingLocation(start);
        this.setSearchArea(area);
        this.setNameQuery(query);
        this.setVerifyList( list );
    }
    
    public String getTestName() {
		return testName;
	}

	public void setTestName(String testName) {
		this.testName = testName;
	}

	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}

	public void setBrowser(String browser) {
		this.browser = browser;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}

	public String getName() {
            return testName;
    }
	
	public String getNameQuery() {
        return nameQuery;
    }
    
    public String getBrowser() {
        return browser;
    }

	public Boolean getEnabled() {
		return enabled;
	}

	public String getUserName() {
		return userName;
	}

	public String getPassWord() {
		return passWord;
	}

	public List<String> getVerifyList() {
		return verifyList.getItems();
	}
	
	public void setVerifyList( MultiItems list ) {
		this.verifyList = list;
	}

	public void setVerifyList( String list ) {
		String[] myArray = list.split(",");
		List<String> listCopy = Arrays.asList( myArray );
		MultiItems mi = new MultiItems();
		for ( String x : listCopy ) {
			mi.addString( x );
		}
		this.verifyList = mi;
	}
	
	public void addToVerifyList( String x ) {
		//TODO
	}

	public String getView() {
		return view;
	}

	public void setView(String view) {
		this.view = view;
	}

	public String getClientIDP() {
		return clientIDP;
	}

	public void setClientIDP(String clientIDP) {
		this.clientIDP = clientIDP;
	}

	public String getEnvironment() {
		return environment;
	}

	public void setEnvironment(String environment) {
		this.environment = environment;
	}

	public String getAppUrl() {
		return appUrl;
	}

	public void setAppUrl(String appUrl) {
		this.appUrl = appUrl;
	}

	public String getLocale() {
		return locale;
	}

	public void setLocale(String locale) {
		this.locale = locale;
	}

	public String getEnvFlag() {
		return envFlag;
	}

	public void setEnvFlag(String envFlag) {
		this.envFlag = envFlag;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getStartingLocation() {
		return startingLocation;
	}

	public void setStartingLocation(String startingLocation) {
		this.startingLocation = startingLocation;
	}

	public String getSearchArea() {
		return searchArea;
	}

	public void setSearchArea(String searchArea) {
		this.searchArea = searchArea;
	}

	public void setNameQuery(String name) {
		this.nameQuery = name;
	}

	public String getSpecialty() {
		return specialty;
	}

	public void setSpecialty(String specialty) {
		this.specialty = specialty;
	}

}
