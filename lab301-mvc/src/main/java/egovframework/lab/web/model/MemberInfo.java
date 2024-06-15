package egovframework.lab.web.model;

public class MemberInfo {
	
	private String id;
	private String name;
	private Address address;
	private String[] favorites;
	private String jobCode;
	private String tool;
	private String etc;
	
	
	public Address getAddress() {
    	return address;
    }
	public void setAddress(Address address) {
    	this.address = address;
    }
	public String[] getFavorites() {
    	return favorites;
    }
	public void setFavorites(String[] favorites) {
    	this.favorites = favorites;
    }
	public String getJobCode() {
    	return jobCode;
    }
	public void setJobCode(String jobCode) {
    	this.jobCode = jobCode;
    }
	public String getTool() {
    	return tool;
    }
	public void setTool(String tool) {
    	this.tool = tool;
    }
	public String getEtc() {
    	return etc;
    }
	public void setEtc(String etc) {
    	this.etc = etc;
    }

	public String getId() {
    	return id;
    }
	public void setId(String id) {
    	this.id = id;
    }
	public String getName() {
    	return name;
    }
	public void setName(String name) {
    	this.name = name;
    }

}
