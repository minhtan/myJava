public class ThreadPool implements Runnable{
	private Work workList[];
	private WorkerThread worker;
	private Object locks;

	public void getWork(int total){
		this.workList = new Work[total];
		for(int i=0; i<total; i++){
			this.workList[i] = new Work();
		}
	}

	public void run(){
		this.locks = new Object();
		this.worker = new WorkerThread(this.locks);
		Thread w1 = new Thread(worker);
		w1.start();

		synchronized(this.locks){
			try{
				this.locks.wait();
			}catch(InterruptedException e){}
		}

		for (int i=0; i<this.workList.length; i++) {
			this.worker.setWork(this.workList[i]);
			System.out.println("Work number: " + (i+1));
			synchronized(this.locks){
				this.locks.notify();
				try{
					this.locks.wait();
				}catch(InterruptedException e){}
			}
		}

		w1.stop();
	}

/*--------------------------------------------------------------------------------
inner class WorkerThread
--------------------------------------------------------------------------------*/
	class WorkerThread implements Runnable{
		private Work work;
		private Object lock;

		public WorkerThread(Object lock){
			this.lock = lock;
		}

		public void setWork(Work work){
			this.work = work;
		}

		public void run(){
			while(true){
				synchronized(this.lock){
					this.lock.notify();
					try{
						this.lock.wait();
					}catch(InterruptedException e){}
					System.out.println("Thread begin working");
					this.work.doWork();
					System.out.println("Thread done working");
				}
			}
		}
	}

}