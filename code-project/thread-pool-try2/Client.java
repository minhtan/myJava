public class Client{
	public static void main(String[] args) {
		System.out.println("Attempt to do 5 works");

		ThreadPool pool = new ThreadPool();
		pool.getWork(5);

		Thread pT = new Thread(pool);
		pT.start();
	}
}