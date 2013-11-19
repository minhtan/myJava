public class Animal implements Runnable{
	protected String name;
	protected int delay;
	public Animal(String name, int delay){
		this.name = name;
		this.delay = delay;
	}
	public void letOut(){
		// for(int i=0; i<10; i++){
		// 	System.out.println("who let the " + this.name + " out");
		// 	try{
		// 		this.sleep(this.delay);
		// 	}catch(InterruptedException e){
		// 		return;
		// 	}
		// }
	}
	public void run(){
		this.letOut();
	}
}