public class Test{
	public static Object lock = new Object();
	public static void main(String[] args){
		Runnable dog = new Dog("dog", 200);
		Thread dogT = new Thread(dog);

		Runnable cat = new Cat("cat", 100, dogT);
		Thread catT = new Thread(cat);

		catT.start();
		dogT.start();
	}
}
/*
Note that every sleep, wait, join method should be surrounded be try-catch block for interrupted exception 
*/

