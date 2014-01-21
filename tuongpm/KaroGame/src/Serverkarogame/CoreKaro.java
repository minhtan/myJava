package Serverkarogame;

import java.awt.Color;

public class CoreKaro {
    private PlayerKaro player;
    private int value;
    private XOButton[][] btnXO;
    private int row, col;
    
    public CoreKaro(){
        this.value = 0;
        this.row = 0;
        this.col = 0;
        btnXO = new XOButton[5][5];
    }

    @Override
    public String toString() {
        return "CoreKaro{" + "player=" + player + ", value=" + value +  ", row=" + row + ", col=" + col + '}';
    }
    
     
    
//    public boolean CreateBoard(int rows, int cols){
//        for (int i = 0; i < rows; i++) {
//            for (int j = 0; j < cols; j++) {
//                chessBoard[row][col] = chessBoard[i][j];
//                row++; 
//                col++;
//            }return true;
//        }
//        return false;
//    }
    
    public void setRow(int row){
        this.row = row;
    }
    public int getRow(){
        return this.row;
    }
    public void setCol(int col){
        this.col = col;
    }
    public int getCol(){
        return this.col;
    }
    
    public void SetLocation(PlayerKaro player,int row, int col,int value){
        this.player = player;
        this.row = row;
        this.col = col;
        this.value = value;
    }
}
