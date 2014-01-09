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

    public void setBase(int[][] base) {
        this.base = base;
    }
}