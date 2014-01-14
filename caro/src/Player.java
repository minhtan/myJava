/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author tannm_b01522
 */
public class Player {
    private int playerNo;
    private Base base;
    private TheGame theGame;

    public Player(int playerNo, Base base, TheGame theGame) {
        this.playerNo = playerNo;
        this.base = base;
        this.theGame = theGame;
    }
    
    public boolean makeMove(int row, int col){
        this.theGame.validateMove(this, row, col);
        return false;
    }
}
