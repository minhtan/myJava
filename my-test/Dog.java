public class Dog extends Animal{
	public Dog(String name, int delay){
		super(name, delay);
	}
	public synchronized void letOut(){
		for(int i=0; i<10; i++){
			System.out.println("who let the " + this.name + " out");
			try{
				this.sleep(this.delay);
			}catch(InterruptedException e){
				return;
			}
		}
		this.notifyAll();
	}
}