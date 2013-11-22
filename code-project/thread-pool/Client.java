public class Client{
	public static void main(String[] args) {
		ThreadPool pool = new ThreadPool();
		System.out.println("Number of works: 10");
		pool.getWork(10);
		Thread t = new Thread(pool);
		t.start();
	}
}