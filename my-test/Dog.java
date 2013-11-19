public class Dog extends Animal{
	public Dog(String name, int delay){
		super(name, delay);
	}
	public void letOut(){
		try{

			for(int i=0; i<10; i++){
				System.out.println("who let the " + this.name + " out");
				Thread.sleep(this.delay);
			}

			synchronized (Test.lock){
				Test.lock.notify();
			}
			
		}catch(InterruptedException e){
			return;
		}
	}
}