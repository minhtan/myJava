public class ThreadPool{
	private MyThread threadList[];
	public ThreadPool(int total){
		this.threadList[] = new MyThread()[total];
		for (int i=0; i<total; i++) {
			this.threadList[i] = new MyThread();
		}
	}
}