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
    
    public void addToVerifyList( String x ) {
		//TODO
	}

	public String getAppUrl() {
		return appUrl;
	}

	public String getBrand() {
		return brand;
	}

	public String getBrowser() {
        return browser;
    }

	public String getClientIDP() {
		return clientIDP;
	}

	public Boolean getEnabled() {
		return enabled;
	}

	public String getEnvFlag() {
		return envFlag;
	}
	
	public String getEnvironment() {
		return environment;
	}
    
    public String getLocale() {
		return locale;
	}

	public String getName() {
            return testName;
    }

	public String getNameQuery() {
        return nameQuery;
    }

	public String getPassWord() {
		return passWord;
	}

	public String getRole() {
		return role;
	}
	
	public String getSearchArea() {
		return searchArea;
	}

	public String getSpecialty() {
		return specialty;
	}
	
	public String getStartingLocation() {
		return startingLocation;
	}

	public String getTestName() {
		return testName;
	}

	public String getUserName() {
		return userName;
	}

	public List<String> getVerifyList() {
		return verifyList.getItems();
	}

	public String getView() {
		return view;
	}

	public void setAppUrl(String appUrl) {
		this.appUrl = appUrl;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public void setBrowser(String browser) {
		this.browser = browser;
	}

	public void setClientIDP(String clientIDP) {
		this.clientIDP = clientIDP;
	}

	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}

	public void setEnvFlag(String envFlag) {
		this.envFlag = envFlag;
	}

	public void setEnvironment(String environment) {
		this.environment = environment;
	}

	public void setLocale(String locale) {
		this.locale = locale;
	}

	public void setNameQuery(String name) {
		this.nameQuery = name;
	}

	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public void setSearchArea(String searchArea) {
		this.searchArea = searchArea;
	}

	public void setSpecialty(String specialty) {
		this.specialty = specialty;
	}

	public void setStartingLocation(String startingLocation) {
		this.startingLocation = startingLocation;
	}

	public void setTestName(String testName) {
		this.testName = testName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
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

	public void setView(String view) {
		this.view = view;
	}

}
