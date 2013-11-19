public class Main {
	public static void main(String[] args) {
		Elevator e = new Elevator((short)5, (short)1);

		System.out.println("Floor 2 call");
		e.move((new Floor((short)2)).getFloorNumber());
		System.out.println(e.getCurrentFloor());

		System.out.println("Floor 4 call");
		e.move((new Floor((short)4)).getFloorNumber());
		System.out.println(e.getCurrentFloor());

		System.out.println("Floor 1 call");
		e.move((new Floor((short)1)).getFloorNumber());
		System.out.println(e.getCurrentFloor());

	}
}