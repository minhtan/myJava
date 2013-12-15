import java.io.*;
public class Car implements Serializable{
	private String make;
	private String model;
	private int year;
	private float price;

	public String getMake() {
	    return this.make;
	}

	public String getModel() {
	    return this.model;
	}

	public int getYear() {
	    return this.year;
	}

	public float getPrice() {
	    return this.price;
	}

	public void setMake(String make) {
	    this.make = make;
	}

	public void setModel(String model) {
	    this.model = model;
	}

	public void setYear(int year) {
	    this.year = year;
	}

	public void setPrice(float price) {
	    this.price = price;
	}
	
	public Car(String make, String model, int year, float price){
		this.make = make;
		this.model = model;
		this.year = year;
		this.price = price;
	}
}