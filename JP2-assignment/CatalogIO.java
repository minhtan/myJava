import java.io.*;
import java.util.*;
public class CatalogIO{
	public void saveCar(ArrayList<Car> cars) {
		ObjectOutputStream objOut = null;
		try{
			objOut = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream("list.ctl")));
			objOut.writeObject(cars);
			objOut.close();
		}catch(IOException e){ 
			System.out.println("Save failed"); 
		}
	}

	public ArrayList<Car> loadCars() { 
		ObjectInputStream objIn = null; 
		ArrayList<Car> carList = new ArrayList<>();  
		try{
			objIn = new ObjectInputStream(new BufferedInputStream(new FileInputStream("list.ctl")));
			carList = (ArrayList<Car>)objIn.readObject(); 
		}catch(EOFException e){
			System.out.println("End of file");
			return carList;
		}catch(ClassNotFoundException e){ 
	    	System.out.println("Class not found"); 
	    }catch(ClassCastException e){
	    	System.out.println("Class cast failed, rewrite save"); 
	    	return carList;
	    }catch(IOException e){ 
			System.out.println("Load failed"); 
		}finally{ 
			try{
				if(objIn != null)
	    			objIn.close(); 
	    	}catch(IOException e){
	    		System.out.println("Close failed");
	    	}
	    }
		return carList;
	}
}