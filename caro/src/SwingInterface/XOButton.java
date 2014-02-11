package SwingInterface;


import java.awt.Dimension;
import java.awt.event.*;
import javax.swing.JButton;

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
    private int player;
    
    public XOButton(int rowPos, int colPos, int player){
        this.value = 0;
        this.rowPos = rowPos;
        this.colPos = colPos;
        this.player = player;
        this.setText(" ");
        this.setFocusable(false);
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        this.value = this.player;
        this.setText(this.value+"");
        this.setEnabled(false);
    }
}
