public class Main{
	public static void main(String[] args) {
		TickTock tickTock = new TickTock();
		Thread tick = new Thread(tickTock);
		Thread tock = new Thread(tickTock);
		tick.start();
		tock.start();
	}
}
class TickTock implements Runnable{
	private boolean tick = true;
	public synchronized void tickTock(){
		try{
			Thread.sleep(1000);
		}catch(InterruptedException e){}
		if(tick == true){
			System.out.println("Tick");
			this.tick = false;
		}else{
			System.out.println("Tock");
			this.tick = true;
		}
	}
	public void run(){
		while(true){
			this.tickTock();
		}
	}
}
