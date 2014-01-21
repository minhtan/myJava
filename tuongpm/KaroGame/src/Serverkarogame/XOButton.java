/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Serverkarogame;

import apj.rmi.server.LocationCell;
import java.awt.Color;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.logging.Level;
import java.util.logging.Logger;
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
    private PanelGame panel;
    private int row, col;

    
    public XOButton(){}
    public XOButton(int row, int col, PanelGame panel){
        valueX = 0;
        this.row = row;
        this.col = col;
        //o = new ImageIcon(this.getClass().getResource("/karogame/image/circle_stroked_24_2x (1).png"));
        x = new ImageIcon(this.getClass().getResource("/karogame/image/cross.png"));
        this.setBorder(BorderFactory.createLineBorder(Color.orange));
        this.setBackground(Color.GREEN);
        //this.addActionListener(this);
        this.panel = panel;
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
        valueX = 1;
        
        this.setBackground(Color.yellow);
        
        int rows = getRow();
        int cols = getCol();
        try {
            LocationCell location = new LocationCell();
            Registry regis = LocateRegistry.createRegistry(12345);
            Naming.rebind("rmi://localhost:12345/local", regis);
            location.setColClient(cols);
            location.setRowClient(rows);
            location.setValueClient(valueX);
        } catch (RemoteException ex) {
            Logger.getLogger(XOButton.class.getName()).log(Level.SEVERE, null, ex);
        } catch (MalformedURLException ex) {
            Logger.getLogger(XOButton.class.getName()).log(Level.SEVERE, null, ex);
        }
        if(panel.checkWin(this)== true){
            JOptionPane.showInputDialog(this, "", "", TOP);
       
        }
            
    }

}