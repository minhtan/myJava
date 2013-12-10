import java.util.Collections;
public class Catalog{
	private Collection<Car> cars;
	public Catalog(){
		this.cars = new ArrayList<Car>();
	}
	public addCar(Car car){
		this.cars.add(car);
	}
	public listCars(){
		for (Car car : this.cars)
    		System.out.println(
    			car.getYear() + " " + 
    			car.getMake() + " " +
    			car.getModel() + "  " + 
    			car.getPrice() 
    		);
	}
}