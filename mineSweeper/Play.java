public class Play{
	private VisibleMap vMap;
	private Map pMap;

	public Play(VisibleMap vMap){
		this.setPlay(vMap);
	}

	public Play(){

	}

	public void setPlay(VisibleMap vMap){
		this.vMap = vMap;
		this.pMap = new Map(vMap.getRow(), vMap.getColumn());
	}

	public Map getPlayMap(){
		return this.pMap;
	}

	public boolean checkNotBomb(int row, int col){
		this.markCell(row, col);
		if(this.vMap.getBase()[row][col] == -1)
			return false;
		else
			return true;
	}

	public void markCell(int row, int col){
		this.pMap.base[row][col] = 1;
	}

	public void checkBombAll(int row, int col){
		if(this.checkNotBomb(row, col)){
			this.markCell(row, col);
			for(int ri=row-1; ri<=row+1; ri++){
				for(int ci=col-1; ci<=col+1; ci++){				
					if( ri>=0 && ri<this.vMap.row &&
						ci>=0 && ci<this.vMap.column &&
						this.pMap.base[ri][ci] != 1 ){							
							checkBombAll(ri, ci);						
					}
				}
			}
		}
	}

	public boolean checkMark(int row, int col){
		if(this.pMap.base[row][col] == 1)
			return true;
		else
			return false;
	}
}