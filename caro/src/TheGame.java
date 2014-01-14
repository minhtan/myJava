/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author tannm_b01522
 */
public class TheGame {
    private Base base;
    private Player player1;
    private Player player2;
    
    public TheGame(int side){
        this.base = new Base(side);
        this.player1 = new Player(1, this.base, this);
        this.player2 = new Player(2, this.base, this);
    }
    
    public boolean validateMove(Player player){
        
        return false; 
    }
}
