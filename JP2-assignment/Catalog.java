import java.io.*;
import java.lang.*;
import java.util.*;
public class Catalog{
	private Collection<Car> cars;
	static Scanner sc = new Scanner(System.in);
	public Catalog(){
		this.cars = new ArrayList<Car>();
	}
	public void addCar(){
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter car's make: ");
		String make = sc.nextLine();

		System.out.print("Enter car's model: ");
		String model = sc.nextLine();

		System.out.print("Enter car's year: ");
		int year = Integer.parseInt(sc.nextLine());

		System.out.print("Enter car's price: ");
		float price = Float.parseFloat(sc.nextLine());

		this.cars.add(new Car(make, model, year, price));
	}
	public void listCars(){
		for (Car car : this.cars)
    		System.out.println(
    			car.getYear() + " " + 
    			car.getMake() + " " +
    			car.getModel() + " " + 
    			car.getPrice() 
    		);
	}
	public static void main(String[] args){
		Catalog ctl = new Catalog();
		boolean dk = true;
		do{
			System.out.print("Enter a command: ");
			String choice = sc.nextLine();
			switch(choice){
				case "add":
					ctl.addCar(); break;
				case "list":
					ctl.listCars(); break;
				case "quit":
					dk = false;
					break;
				default:
					System.out.print("Invalid command! ");
					break;
			}
		}while(dk);
	}
}