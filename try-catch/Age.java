public class Age{
	private int age;
	public Age(){}
	public int getAge(){
		return this.age;
	}
	public void setAge(int newAge) throws InvalidAgeException{
		if(newAge>0 && newAge<200)
			this.age = newAge;
		else
			throw new InvalidAgeException(newAge, 0 ,200);
	}
}