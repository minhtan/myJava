import java.util.Random;
public class MineMap extends Map
{  
  public MineMap(int row, int column){
    super(row, column);    
    this.bombValue = -1;
  }

  public MineMap(){
    super();
    this.bombValue = -1;
  }

  public void setMap(int row, int column){
    super.setMap(row, column);    
  }

  public void randomBase(){
    Random rand = new Random();
    for(int ri=0; ri<this.row; ri++){
      for(int ci=0; ci<this.column; ci++){
        this.base[ri][ci] = rand.nextInt(100)%2*(-1);
      }
    }
  }
  
  public boolean randomBase(int maxBomb){
    if(maxBomb<=this.row*this.column){
    	int curntBomb = 0;
      int curntRow, curntCol;
    	Random rand = new Random();
      while(curntBomb < maxBomb){
        curntRow = rand.nextInt(this.row);
        curntCol = rand.nextInt(this.column);
        if(this.base[curntRow][curntCol] != this.bombValue){
          this.base[curntRow][curntCol] = this.bombValue;
          curntBomb ++;
        }
      }
      return true;
    }
    else
      return false;
  }
}
