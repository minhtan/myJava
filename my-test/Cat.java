public class Cat extends Animal{
	public Cat(String name, int delay){
		super(name, delay);
	}
	public synchronized void letOut(){
		for(int i=0; i<10; i++){
			if(i==5){
				try{
					this.wait();
				}catch(InterruptedException e){
					return;
				}
			}
			System.out.println("who let the " + this.name + " out");
			try{
				this.sleep(this.delay);
			}catch(InterruptedException e){
				return;
			}
		}
	}
}