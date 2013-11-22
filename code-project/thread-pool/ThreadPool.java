public class ThreadPool implements Runnable{
	private MyThread workerThread;
	public Object lock = new Object();
	private Work workList[];
	public ThreadPool(){
		this.workerThread = new MyThread(this);
	}
	public void getWork(int totalWork){
		this.workList = new Work[totalWork];
		for(int i=0; i<totalWork; i++){
			this.workList[i] = new Work();
		}
	}
	public void run(){
		Thread wT = new Thread(workerThread);
		wT.start();
		for(int i=0; i<this.workList.length; i++){
			this.workerThread.setWork(this.workList[i]);
			synchronized(this.lock){
				this.lock.notify();
				try{
					this.lock.wait();
				}catch(InterruptedException e){}
			}
		}
	}
}