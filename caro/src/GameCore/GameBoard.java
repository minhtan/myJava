/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package GameCore;

/**
 *
 * @author Tan
 */
public class GameBoard{
    private int[][] base;
    private int side;

    public GameBoard(int side) {
        this.side = side;
        this.base = new int[side][side];
        for(int row=0; row<side; row++){
            for(int col=0; col<side; col++){
                this.base[row][col] = 0;
            }
        }
    }
    
    public int[][] getBase() {
        return base;
    }

    public int getSide() {
        return side;
    }
    
    public void setSide(int side) {
        this.side = side;
    } 
}
