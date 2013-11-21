public class MyThread implements Runnable{
	private Work work;
	public setWork(Work work){
		this.work = work;
	}
	public void run(){
		this.work.do();
	}
}