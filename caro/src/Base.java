/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author tannm_b01522
 */
public class Base {
    private int side;
    private int base[][];

    public Base(int side){
        this.side = side;
        this.base = new int[side][side];
        for(int r=0; r<side; r++){
            for(int c=0; c<side; c++){
                this.base[r][c] = 0;
            }
        }
    }
    
    public int getSide() {
        return side;
    }

    public void setSide(int side) {
        this.side = side;
    }

    public int[][] getBase() {
        return base;
    }
}