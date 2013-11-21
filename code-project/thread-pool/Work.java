public class Work{
	public void do(){
		for (int i=1; i<=10; i++){
			System.out.println("This is line: "+i);
			try{
				Thread.sleep(200);
			}catch(InterruptedException e){}
		}
	}
}