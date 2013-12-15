import java.io.*;
import java.util.*;
public class CatalogIO{
	public void saveCar(Car car) {
		ObjectOutputStream objOut = null;
		try{
			objOut = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream("list.ctl", true)));
			objOut.writeObject(car);
			objOut.close();
		}catch(IOException e){ 
			System.out.println("save failed"); 
		}
	}

	public ArrayList<Car> loadCars() { 
		ObjectInputStream objIn = null; 
		ArrayList<Car> carList = new ArrayList<Car>();  
		try{
			objIn = new ObjectInputStream(new BufferedInputStream(new FileInputStream("list.ctl")));
		    while(true){  
			    carList.add( (Car)objIn.readObject() ); 
			}
		}catch(EOFException e){
			System.out.println("load successfully");
			return carList;
		}catch(ClassNotFoundException e){ 
	    	System.out.println("class Car not found"); 
	    }catch(IOException e){ 
			System.out.println("load failed"); 
		}finally{ 
			try{
				if(objIn != null)
	    			objIn.close(); 
	    	}catch(IOException e){
	    		System.out.println("close failed");
	    	}
	    }
		return carList;
	}
}