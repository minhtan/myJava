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
		// this.cars = new ArrayList<Car>();
		this.io = new CatalogIO();
		this.cars = this.io.loadCars();
	}

	public void addCar(String make, String model, int year, float price){
		Car car = new Car(make, model, year, price);
		this.cars.add(car);
		this.io.saveCar(this.cars);
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