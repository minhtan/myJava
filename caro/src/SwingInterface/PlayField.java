package SwingInterface;

import java.awt.*;
import javax.swing.*;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author tannm_b01522
 */
public class PlayField extends JPanel {
    private GameInterface swing;
    private XOButton[][] board;

    public XOButton getButton(int row, int col) {
        return board[row][col];
    }
    
    public PlayField(int side, GameInterface swing){
        this.swing = swing;
        this.board = new XOButton[side][side];
        this.setLayout(new GridLayout(side, side));
        for (int row = 0; row < side; row++) {
            for(int col = 0; col < side; col++){
                this.board[row][col] = new XOButton(row, col, this.swing);
                this.board[row][col].addActionListener(this.board[row][col]);
                this.add(this.board[row][col]);
            }
        }
    }
}
