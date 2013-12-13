import java.util.*;
public class Catalog{
	private ArrayList<Car> cars;
	private CatalogIO io;

	public ArrayList<Car> getCars() {
	    return this.cars;
	}

	public void setCars(ArrayList<Car> cars) {
	    this.cars = cars;
	}

	public Catalog(){
		this.io = new CatalogIO();
		this.cars = io.load();
	}

	public void addCar(String make, String model, int year, float price){
		Car car = new Car(make, model, year, price);
		this.cars.add(car);
		this.io.save(car);
	}

	public String listCar(Car car){
		return ( 
			this.cars.indexOf(car) + "|" +
			car.getMake() + "|" + 
			car.getModel() + "|" +
			car.getYear() + "|" +
			car.getPrice()
		);
	}
}