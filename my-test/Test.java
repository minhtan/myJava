public class Test{
	public static void main(String[] args){;
		Animal cat = new Cat("cat", 1000);
		Animal dog = new Dog("dog", 1500);

		cat.start();
		dog.start();
	}
}

