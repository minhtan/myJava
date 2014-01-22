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
    private int value = 0;
    public XOButton(){
        this.setText(this.value+"");
    }
    @Override
    public void actionPerformed(ActionEvent ae) {
        this.value ++;
        if(this.value > 1){
            this.value = 0;
        }
        this.setText(this.value+"");
    }
}
