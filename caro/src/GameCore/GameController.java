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
    private int count;

    public GameController(int side) {
        this.board = new GameBoard(side);
    }
    
    private boolean validateMove(int row, int col){
        if(this.board.getBase()[row][col] == 0)
            return true;
        else
            return false;
    }
    
    public void makeAMove(int row, int col, int player){
        if(this.validateMove(row, col) == true)
            this.board.getBase()[row][col] = player;
    }
    
    public int checkWinner(int row, int col){
        int winner = 0;
        int player = this.board.getBase()[row][col];
        this.count = 0;
        
        //check diagonally 1->9
        this.count = 0;
        if(this.check(row, col, player, -1, -1))
            winner = player;
        else if(this.check(row, col, player, +1, +1))
            winner = player;
        if(winner != 0)
            return winner;
        
        //check disagonally 7->3
        this.count = 0;
        if(this.check(row, col, player, +1, -1))
            winner = player;
        else if(this.check(row, col, player, -1, +1))
            winner = player;
        if(winner != 0)
            return winner;
        
        //check vertically
        this.count = 0;
        if(this.check(row, col, player, -1, 0))
            winner = player;
        else if(this.check(row, col, player, +1, 0))
            winner = player;
        if(winner != 0)
            return winner;
        
        //check horizontally
        this.count = 0;
        if(this.check(row, col, player, 0, -1))
            winner = player;
        else if(this.check(row, col, player, 0, +1))
            winner = player;
        if(winner != 0)
            return winner;
        
        return winner; 
    }
    
    private boolean check(int row, int col, int player, int rowStep, int colStep){
        if(this.board.getBase()[row+rowStep][col+colStep] != player && this.board.getBase()[row+rowStep][col+colStep] != 0)
            this.count -= 2;
        if(this.board.getBase()[row+rowStep][col+colStep] == player){
            this.count ++;
            if(this.count == 4)
                return true;
            if(this.check(row+rowStep, col+colStep, player, rowStep, colStep))
                return true;
        }
        return false;
    }
    
}
