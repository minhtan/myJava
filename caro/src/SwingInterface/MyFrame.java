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
public class MyFrame extends JFrame {
    private JPanel playField;

    public JPanel getPlayField() {
        return playField;
    }

    public void setPlayField(JPanel playField) {
        this.playField = playField;
    }
    
    public MyFrame(int side, int player){
        this.playField = new JPanel(new GridLayout(side, side));
        for (int row = 0; row < side; row++) {
            for(int col = 0; col < side; col++){
                XOButton btn = new XOButton(row, col, player);
                btn.addActionListener(btn);
                this.playField.add(btn);
            }
        }
        this.getContentPane().add(this.playField);
        this.setVisible(true);
        this.pack();
        this.setResizable(false);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
    
    public static void main(String[] args) {
        MyFrame frame = new MyFrame(3, 1);
    }
}
