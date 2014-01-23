/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package GameCore;

/**
 *
 * @author Tan
 */
public class GameController {
    private GameBoard board;

    public GameController(int side) {
        this.board = new GameBoard(side);
    }
    
    public boolean validateMove(int row, int col){
        if(this.board.getBase()[row][col] == 0)
            return true;
        else
            return false;
    }
    
    public boolean makeAMove(int row, int col, int player){
        try{
            this.board.getBase()[row][col] = player;
        }catch(Exception e){
            return false;
        }
        return false;
    }
    
    public int checkWinner(int row, int col){
        int winner = 0;
        int player = this.board.getBase()[row][col];
        
        return winner;
    }
    
    private boolean checkDiagLR(){
        
        return true;
    }
}
