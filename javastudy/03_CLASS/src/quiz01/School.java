package quiz01;

public class School {

	// field
	private String name;
	private String location;
	
	// constructor
	public School(String name, String location) {
		this.name = name;
		this.location = location;
	}
	public School() {
		
	}
	
	// method
	public String getName() {
		return name;
	}
	public String getLocation() {
		return location;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	
}
