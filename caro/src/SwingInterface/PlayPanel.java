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
public class PlayPanel extends JPanel {
    public PlayPanel(int side, int player){
        this.setLayout(new GridLayout(side, side));
        for (int row = 0; row < side; row++) {
            for(int col = 0; col < side; col++){
                XOButton btn = new XOButton(row, col, player);
                btn.addActionListener(btn);
                this.add(btn);
            }
        }
    }
}
