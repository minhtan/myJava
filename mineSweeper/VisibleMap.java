public class VisibleMap extends Map
{
  private MineMap mineMap;   

  public VisibleMap(MineMap mineMap){
    super(mineMap.getRow(), mineMap.getColumn());
    this.mineMap = mineMap;
    this.bombValue = -1;
  }

  public VisibleMap(){
    super();
    this.bombValue = -1;
  }

  public void setMap(MineMap mineMap){
    super.setMap(mineMap.getRow(), mineMap.getColumn());
    this.mineMap = mineMap;
  }

  public void convertMap(){
    for(int ri=0; ri<this.row; ri++){
      for(int ci=0; ci<this.column; ci++){
        if(this.mineMap.getBase()[ri][ci]==0)   
			    this.base[ri][ci] = calculateBomb(ri, ci);
        else
          this.base[ri][ci] = this.bombValue;
      }
    }
  }
  
  public int calculateBomb(int crntRow, int crntCol){
  	int totalBomb = 0;
  	  for(int riChecker=crntRow-1; riChecker<=crntRow+1; riChecker++){
    		for(int ciChecker=crntCol-1; ciChecker<=crntCol+1; ciChecker++){
    		  if(riChecker>=0 && riChecker<this.row &&
    			ciChecker>=0 && ciChecker<this.column &&
    			!(riChecker==crntRow && ciChecker==crntCol)){
    			  totalBomb = totalBomb + this.mineMap.getBase()[riChecker][ciChecker]*(-1);
    		  }
    		}
  	  }
  	return totalBomb;
  }
}
