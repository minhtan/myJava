public class Meow{
	public static synchronized void meow(){
		try{
			System.out.println("meow");
			Thread.sleep(500);
			System.out.println("meow");
			Thread.sleep(500);
			System.out.println("Finish meow");
		}catch(InterruptedException e){
			return;
		}
	}
}