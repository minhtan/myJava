public class Cat extends Animal{
	public Thread dogTRef;
	public Cat(String name, int delay, Thread dogT){
		super(name, delay);
		this.dogTRef = dogT;
	}
	public void letOut(){
		//synchornized method test
		// Meow.meow();

		try{
			for(int i=0; i<10; i++){

				//interrupted test
				// if(i==2){
				// 	this.dogTRef.interrupt();
				// }

				//join test
				// if(i==4){
				// 	this.dogTRef.join();
				// }

				//wait test
				if(i==4){ 
					synchronized(Test.lock){
						Test.lock.wait();
					}
				}
				
				System.out.println("who let the " + this.name + " out");
				Thread.sleep(this.delay);
			}
			synchronized(Test.lock){
				Test.lock.notify();
			}
		}catch(InterruptedException e){
			return;
		}
	}
}