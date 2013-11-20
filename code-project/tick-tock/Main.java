public class Main{
	public static Object lock = new Object();
	public static void main(String[] args) {
		Tick tick = new Tick();
		Tock tock = new Tock();
		Thread tickT = new Thread(tick);
		Thread tockT = new Thread(tock);
		tickT.start();
		tockT.start();
	}
}

class Tick implements Runnable{
	public void tick(){
		System.out.println("Tick");
	}
	public void run(){
		try{
			while(true){		
				this.tick();
				Thread.sleep(1000);
				synchronized(Main.lock){
					Main.lock.notify();
					Main.lock.wait();
				}
			}
		}catch(InterruptedException e){}
	}
}

class Tock implements Runnable{
	public void tock(){
		System.out.println("Tock");
	}
	public void run(){
		try{
			while(true){
				synchronized(Main.lock){
					Main.lock.wait();
				}
				this.tock();
				Thread.sleep(1000);
				synchronized(Main.lock){	
					Main.lock.notify();
				}
			}
		}catch(InterruptedException e){}
	}
}