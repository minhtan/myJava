/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Serverkarogame;


import apj.rmi.server.LocationCell;
import java.awt.Color;
import java.awt.GridLayout;

/**
 *
 * @author tuong
 */
public class PanelGame extends javax.swing.JPanel {
    String namePlayer ;
    XOButton[][] btnXO = new XOButton[MAX_ROWS][MAX_COLS];
    public static final int MAX_ROWS = 15;
    public static final int MAX_COLS = 15;
    private int valueX = 1;

    //private LoginGameServer server;
    /**
     * Creates new form panelMain
     */
    public PanelGame() {
        initComponents();
        this.setLayout(new GridLayout(MAX_ROWS, MAX_ROWS));
        for (int i = 0; i < MAX_ROWS; i++) {
            for (int j = 0; j < MAX_COLS; j++) {
                btnXO[i][j] = new XOButton(i,j, this);
                btnXO[i][j].addActionListener(btnXO[i][j]);
                this.add(btnXO[i][j]);
            }
        }
    }
    
    public boolean checkWin(XOButton btn){
        for (int i = 0; i < MAX_ROWS; i++) {
            for (int j = 0; j < MAX_COLS; j++) {
                
                if(btnXO[i][j].getCol() == btn.getCol() && btnXO[i][j].getRow() == btn.getRow()){
                     //xet truong hop duong cheo ban co tu phai sang
                    if(btnXO[i][j].getValueX() == valueX && btnXO[i-1][j+1].getValueX()== valueX && btnXO[i-2][j+2].getValueX() == valueX
                                                   && btnXO[i-3][j+3].getValueX() == valueX){
                        btnXO[i][j].setBackground(Color.BLACK);
                        btnXO[i-1][j+1].setBackground(Color.BLACK);
                        btnXO[i-2][j+2].setBackground(Color.BLACK);
                        btnXO[i-3][j+3].setBackground(Color.BLACK);
                        return true;
                    }else if(btnXO[i][j].getValueX()== valueX && btnXO[i+1][j-1].getValueX() == valueX && btnXO[i+2][j-2].getValueX()==valueX
                            && btnXO[i+3][j-3].getValueX()== valueX){
                        btnXO[i][j].setBackground(Color.BLACK);
                        btnXO[i+1][j-1].setBackground(Color.BLACK);
                        btnXO[i+2][j-2].setBackground(Color.BLACK);
                        btnXO[i+3][j-3].setBackground(Color.BLACK);
                        return true;
                    
                    }
                    //xet win duong cheo tu trai sang
                    else if(btnXO[i][j].getValueX() == valueX && btnXO[i+1][j+1].getValueX()== valueX && btnXO[i+2][j+2].getValueX()== valueX
                            && btnXO[i+3][j+3].getValueX() == valueX){
                        btnXO[i][j].setBackground(Color.BLACK);
                        btnXO[i+1][j+1].setBackground(Color.BLACK);
                        btnXO[i+2][j+2].setBackground(Color.BLACK);
                        btnXO[i+3][j+3].setBackground(Color.BLACK);
                        return true;
                    }else if(btnXO[i][j].getValueX()== valueX && btnXO[i-1][j-1].getValueX()== valueX && btnXO[i-2][j-2].getValueX()== valueX
                            && btnXO[i-3][j-3].getValueX()== valueX){
                        btnXO[i][j].setBackground(Color.BLACK);
                        btnXO[i-1][j-1].setBackground(Color.BLACK);
                        btnXO[i-2][j-2].setBackground(Color.BLACK);
                        btnXO[i-3][j-3].setBackground(Color.BLACK);
                        return true;
                    }
                    
                    //xet win duong doc tu tren xuong, thieu vi tri bit dau` va bit cuoi
                
                    else if(btnXO[i][j].getValueX() == valueX && btnXO[i+1][j].getValueX()==valueX && btnXO[i+2][j].getValueX() == valueX 
                            && btnXO[i+3][j].getValueX()==valueX){
                        btnXO[i][j].setBackground(Color.BLACK);
                        btnXO[i+1][j].setBackground(Color.BLACK);
                        btnXO[i+2][j].setBackground(Color.BLACK);
                        btnXO[i+3][j].setBackground(Color.BLACK);
                        return true;

                    }else if(btnXO[i][j].getValueX()== valueX && btnXO[i-1][j].getValueX() == valueX && btnXO[i-2][j].getValueX() == valueX
                                && btnXO[i-3][j].getValueX() == valueX){
                        btnXO[i][j].setBackground(Color.BLACK);
                        btnXO[i-1][j].setBackground(Color.BLACK);
                        btnXO[i-2][j].setBackground(Color.BLACK);
                        btnXO[i-3][j].setBackground(Color.BLACK);
                        return true;
                    }
                    //xet hang ngang tu trai sang
                    else if(btnXO[i][j].getValueX()== valueX && btnXO[i][j+1].getValueX() == valueX && btnXO[i][j+2].getValueX() == valueX
                                && btnXO[i][j+3].getValueX() == valueX){
                        btnXO[i][j].setBackground(Color.BLACK);
                        btnXO[i][j+1].setBackground(Color.BLACK);
                        btnXO[i][j+2].setBackground(Color.BLACK);
                        btnXO[i][j+3].setBackground(Color.BLACK);
                        return true;
                    }
                    //xet hang ngang tu phai sang
                    else if(btnXO[i][j].getValueX()== valueX && btnXO[i][j-1].getValueX() == valueX && btnXO[i][j-2].getValueX() == valueX
                                && btnXO[i][j-3].getValueX() == valueX){
                        btnXO[i][j].setBackground(Color.BLACK);
                        btnXO[i][j-1].setBackground(Color.BLACK);
                        btnXO[i][j-2].setBackground(Color.BLACK);
                        btnXO[i][j-3].setBackground(Color.BLACK);
                        return true;
                    }
                }
            }
        }return false;
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setPreferredSize(new java.awt.Dimension(500, 500));
        setLayout(new java.awt.GridLayout(1, 0));
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
