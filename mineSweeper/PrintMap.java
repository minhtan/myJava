public class PrintMap
{
  private Map map;
  private Map playMap;
  
  public PrintMap(){
    
  }

  public void setMap(Map map){
    this.map = map;
  }
	
  public void setPlayMap(Map map){
    this.playMap = map;
  }
  
  public void print(int bombValue, boolean printAll){
    //start print outline
    System.out.print("   ");
    for(int ci=1; ci<=map.getColumn(); ci++)
      System.out.print(String.format("%2d", ci) + " ");

    System.out.print("\n");

    System.out.print("   ");
    for(int ci=1; ci<=map.getColumn(); ci++)
      System.out.print("---");
    
    System.out.print("\n");
    //end print outline

    for(int ri=0; ri<map.getRow(); ri++){
      System.out.print(String.format("%2d", ri+1) + "|"); //another outline
      for(int ci=0; ci<map.getColumn(); ci++){
		    if(this.playMap.getBase()[ri][ci] == 1 || printAll){
			    if(this.map.getBase()[ri][ci]==bombValue)
			     System.out.print(" * ");
			    else
			     System.out.print(" " + map.getBase()[ri][ci] + " ");
		    }
        else
			    System.out.print(" - ");	  
	    }
	  System.out.print("\n  |\n");//yet another outline
    }
    
    System.out.print("\n");
  }
  
}
