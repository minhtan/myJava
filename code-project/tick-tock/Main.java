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
		synchronized(Main.lock){
			System.out.println("Tick");
			try{
				Thread.sleep(1000);
				Main.lock.notify();
				Main.lock.wait();
			}catch(InterruptedException e){}
		}
	}
	public void run(){
		while(true){
			this.tick();
		}
	}
}

class Tock implements Runnable{
	public void tock(){
		synchronized(Main.lock){
			System.out.println("Tock");
			try{
				Thread.sleep(1000);
				Main.lock.notify();
				Main.lock.wait();
			}catch(InterruptedException e){}
		}
	}
	public void run(){
		while(true){
			this.tock();
		}
	}
}