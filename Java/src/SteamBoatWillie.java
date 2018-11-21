public class SteamBoatWillie extends Vehicle {

	//constructor with no field (a "no-args" constructor) - Always have to have one!
	public SteamBoatWillie() {
		System.out.println("called noargs constructor");
	}

	//constructor with all the fields
	public SteamBoatWillie(int yearManufactured, String model, String make, String disney) {
		//"this" refers to the SteamBoatWillie object being created, NOT the argument
		this.yearManufactured = yearManufactured;
		this.model = model;
		this.make = make;
		this.disney = disney;
	}

	//private instance variables, accessible only within the class
	private int yearManufactured; //int -> integer, for a number
	private String model;
	private String make;
	private String disney;

	//getters and setters (accessors and mutators)
	public int getYearManufactured() {
		return this.yearManufactured;
	}
	
	public String getModel() {
		return this.model;
	}

	public String getMake() {
		return this.make;
	}

	public String getDisney() {
		return this.disney;
	}

	public void setYearManufactured(int year) {
		this.yearManufactured = year;
	}
	
	public void setMeodel(String model) {
		this.model = model;
	}

	public void setMake(String model) {
		this.make = make;
	}
	
	public void setDisney(String disney) {
		this.disney = disney;
	}

	//Override inherited move() method
	@Override	//doesnt DO anything, but will fail to compile if no matching superclass method
	public void move() {
		System.out.println("Car is moving");
	}
}
