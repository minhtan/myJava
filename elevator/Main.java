
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);

		Elevator e = new Elevator((short)5, (short)1);

		while(true) {
                    System.out.println("Here is "  + "floor " + e.getCurrentFloor());
                    System.out.print("Please chose floor you want to go: ");
                    short f = s.nextShort();
                    e.move(f);
                }
        }
}