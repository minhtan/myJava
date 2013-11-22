public class Work{
	public void doWork(){
		System.out.println("This is a work, it will sleep for 2 sec");
		try{
			Thread.sleep(2000);
		}catch(InterruptedException e){}
		System.out.println("Done");
	}
}