public class Work{
	public void doWork(){
		try{
			Thread.sleep(1000);
			System.out.println("Doing some work here");
			Thread.sleep(1000);
		}catch(InterruptedException e){}
	}
}