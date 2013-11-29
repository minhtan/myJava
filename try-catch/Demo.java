import java.util.Scanner;
public class Demo{
	public static void main(String [] args){
		Age age = new Age();
		Scanner sc = new Scanner(System.in);
		while(true){
			System.out.print("In put an age: ");
			try{
				age.setAge( Integer.parseInt(sc.nextLine()) );
				break;
			}catch(InvalidAgeException e){
				System.out.println("Sorry, you in put an invalid age: " + e.getAge());
				System.out.println("Age must be between: " + e.getMin() + " and " + e.getMax());
				e.printStackTrace();
			}catch(NumberFormatException e){
				System.out.println("Sorry, you in put an invalid character");
				e.printStackTrace();
			}
		}
	}
}