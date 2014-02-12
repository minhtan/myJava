package SwingInterface;


import Game.TheGame;
import SocketNetwork.Data;
import java.awt.Dimension;
import java.awt.event.*;
import javax.swing.JButton;
import javax.swing.JFrame;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author tannm_b01522
 */
public class XOButton extends JButton implements ActionListener{
    private int value;
    private int rowPos;
    private int colPos;

    private GameInterface swing;
    
    public XOButton(int rowPos, int colPos, GameInterface swing){
        this.swing = swing;
        this.value = 0;
        this.rowPos = rowPos;
        this.colPos = colPos;
        this.setText(" ");
        this.setFocusable(false);
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        if(this.swing.getFlag() == true){
            this.value = this.swing.getPlayerNo();
            this.setText(this.value+"");
            this.setEnabled(false);
            
            this.swing.setData( new Data(this.rowPos, this.colPos, this.swing.getPlayerNo()) );
            
            synchronized(TheGame.lock){
                TheGame.lock.notify();
            }
        }
    }
    
    public void update(int player){
        this.value = player;
        this.setText(this.value+"");
        this.setEnabled(false);
    }
}
