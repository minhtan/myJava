import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
    
    public MyFrame(){
        this.playField = new JPanel(new GridLayout(3,3));
        for (int i = 0; i < 9; i++) {
            XOButton btn = new XOButton();
            btn.addActionListener(btn);
            this.playField.add(btn);
        }
        this.getContentPane().add(this.playField);
        this.setVisible(true);
        this.pack();
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
    
    public static void main(String[] args) {
        JFrame myFrame = new MyFrame();
    }
}
