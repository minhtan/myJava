/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ClientKaroGame;

import java.awt.Color;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Action;
import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.border.EmptyBorder;


public class XOButton extends JButton implements ActionListener{
    ImageIcon x, o;
    private String cellXO;
    private int valueX;
    //private LoginGameServer server;
    private PanelGame panelMain;
    private int row, col;
    
    public XOButton(){}
    
    public XOButton(int row, int col, PanelGame panelMain){
        valueX = 0;
        this.row = row;
        this.col = col;
        //o = new ImageIcon(this.getClass().getResource("/karogame/image/circle_stroked_24_2x (1).png"));
        x = new ImageIcon(this.getClass().getResource("/karogame/image/cross.png"));
        this.setBorder(BorderFactory.createLineBorder(Color.orange));
        this.setBackground(Color.GREEN);
        //this.addActionListener(this);
        this.panelMain = panelMain;
    }
    
    
    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }

    public int getValueX(){
        return this.valueX;
    }
    public void setValueX(int value){
        this.valueX = value;    
    }
    public void actionPerformed(ActionEvent avt){
        valueX = 2;
        
        this.setBackground(Color.yellow);
         
        if(panelMain.checkWin(this)== true){
            JOptionPane.showInputDialog(this, "", "", TOP);
        }
            
    }

}