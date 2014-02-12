/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package SocketNetwork;

import java.io.Serializable;

/**
 *
 * @author Administrator
 */
public class Data implements Serializable{
    private int row;
    private int col;
    private int player;
 
    public Data(int row, int col, int player) {
        this.row = row;
        this.col = col;
        this.player = player;
    }
    
    public int getPlayer() {
        return player;
    }

    public void setPlayer(int player) {
        this.player = player;
    }
    
    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getCol() {
        return col;
    }

    public void setCol(int col) {
        this.col = col;
    }
}
