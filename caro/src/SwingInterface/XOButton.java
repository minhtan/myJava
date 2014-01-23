package SwingInterface;


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
    
    public XOButton(int rowPos, int colPos){
        this.value = 0;
        this.rowPos = rowPos;
        this.colPos = colPos;
        this.setText(" ");
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        XOButton source = (XOButton) ae.getSource();
        
    }
}
