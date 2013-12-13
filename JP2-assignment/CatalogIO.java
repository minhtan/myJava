import java.io.*;
import java.util.*;
public class CatalogIO{
	private ObjectOutputStream objOut;
	private ObjectInputStream objIn;

	public void save(Car car) {
		try{
			this.objOut = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream("list.ctl", true)));
			this.objOut.writeObject(car);
		}catch(IOException e){}
		finally{
			if(this.objOut != null)
				this.objOut.close();
		}
	}

	public ArrayList load() {   
		this.objIn = new ObjectInputStream(new BufferedInputStream(new FileInputStream("list.ctl")));
	    ArrayList<Car> carList = null;  
	    while(true){  
		    try{  
		        carList.add( (Car)objIn.readObject() );  
		    }catch(EOFException e){return carList;}
		}
	}
}