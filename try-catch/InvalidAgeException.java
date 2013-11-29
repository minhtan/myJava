public class InvalidAgeException extends NumberFormatException{
	private int age;
	private int min;
	private int max;
	public InvalidAgeException(int age, int min, int max){
		this.age = age;
		this.min = min;
		this.max = max;
	}
	public int getAge(){
		return this.age;
	}
	public int getMin(){
		return this.min;
	}
	public int getMax(){
		return this.max;
	}

}