import java.util.*;
import java.lang.*;
public class Console{
	static Scanner sc = new Scanner(System.in);
	private Catalog ctl = new Catalog();

	public static void main(String[] args){
		Console csl = new Console();
		boolean loop = true;
		do{
			System.out.print("Enter a command (type 'help' for information): ");
			String choice = sc.nextLine();
			switch(choice){
				case "add":
					csl.add(); break;
				case "list":
					csl.list(); break;
				case "help":
					System.out.println("\n");
					System.out.println("list: list out all cars"); 
					System.out.println("add : add a car");
					System.out.println("quit: quit");
					System.out.println("\n");
					break;
				case "quit":
					loop = false;
					break;
				default:
					System.out.print("Invalid command! ");
					break;
			}
		}while(loop);
	}

	public void add() throws NumberFormatException{
		System.out.print("Enter car's make: ");
		String make = sc.nextLine();

		System.out.print("Enter car's model: ");
		String model = sc.nextLine();

		int year;
		while(true){
			System.out.print("Enter car's year: ");
			try{
				year = Integer.parseInt(sc.nextLine());
				break;
			}catch(NumberFormatException e){
				System.out.print("Invalid input format. ");
			}
		}

		float price;
		while(true){
			System.out.print("Enter car's price: ");
			try{
				price = Float.parseFloat(sc.nextLine());
				break;
			}catch(NumberFormatException e){
				System.out.print("Invalid input format. ");
			}
		}

		ctl.addCar(make, model, year, price);
	}

	public void list(){
		System.out.println("\nCar list:\n");
		for (Car car : ctl.getCars()){
			StringTokenizer st = new StringTokenizer(ctl.listCar(car), "|");
			 	
			int index = 1 + Integer.parseInt(st.nextElement().toString());
		 	String make = st.nextElement().toString();
		 	String model = st.nextElement().toString();
		    int year = Integer.parseInt(st.nextElement().toString());
		    float price = Float.parseFloat(st.nextElement().toString());
 
			StringBuilder sb = new StringBuilder();
			sb.append(index + ". ");
			sb.append(year + " ");
			sb.append(make + " ");
			sb.append(model);
			sb.append(", price: " + price);
			sb.append("\n*************************************\n");
 
			System.out.println(sb.toString());
		}
	}
}