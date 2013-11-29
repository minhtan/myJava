public class Map
{
  protected int[][] base;
  protected int row;
  protected int column;
  protected int bombValue;

  public Map(){
    
  }

  public Map(int row, int column){
    this.setMap(row, column);
  }

  public void setMap(int row, int column){
    this.row = row;
    this.column = column;
    this.base = new int[this.row][this.column];
    this.setBase();
  }

  public int getBombValue(){
    return this.bombValue;
  }
  
  public int getRow(){
    return this.row;
  }

  public int getColumn(){
    return this.column;
  }

  public int[][] getBase(){
    return this.base;
  }

  public void setBase(){
    for(int ri=0; ri<this.row; ri++){
        for(int ci=0; ci<this.column; ci ++){
          this.base[ri][ci] = 0;
        }
    }
  }
}
