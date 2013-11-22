public class ThreadPool implements Runnable{
	private Work workList[];
	private WorkerThread worker;

	public getWork(int total){
		for(int i=0; i<this.workList.length; i++){
			this.workList[i] = new Work();
		}
	}

	public void run(){
		this.worker = new WorkerThread();
		Thread w1 = new Thread(worker);
		
	}

/*--------------------------------------------------------------------------------
inner class WorkerThread
--------------------------------------------------------------------------------*/
	class WorkerThread implements Runnable{
		private Work work;
		public void setWork(Work work){
			this.work = work;
		}
		public void run(){

		}
	}
}