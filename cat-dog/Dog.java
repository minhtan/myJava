public class Dog extends Animal{
	public Dog(String name, int delay){
		super(name, delay);
	}
	public void letOut(){
		//synchornized method test
		// Meow.meow();
		
		try{
			for(int i=0; i<10; i++){
				if(i==6){
					synchronized (Test.lock){
						Test.lock.notify();
						Test.lock.wait();
					}
				}
				System.out.println("who let the " + this.name + " out");
				Thread.sleep(this.delay);
			}
			
		}catch(InterruptedException e){
			return;
		}
	}
}