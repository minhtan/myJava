public class MyThread implements Runnable{
	private Work work;
	private ThreadPool tp;
	public MyThread(ThreadPool tp){
		this.tp = tp;
	}
	public void setWork(Work work){
		this.work = work;
	}
	public void run(){
		while(true){
			synchronized(this.tp.lock){
				try{
					this.tp.lock.wait();
				}catch(InterruptedException e){}
			}
			System.out.println("Thread start working");
			this.work.doWork();
			System.out.println("Thread done working");
			synchronized(this.tp.lock){
				this.tp.lock.notify();
			}
		}
	}
}