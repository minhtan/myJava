
package Serverkarogame;

public class FunctionKaro {
    private PlayerKaro player1;
    private PlayerKaro player2;
    private CoreKaro board;
    private int row, col,value;
    
    public FunctionKaro(){
        board = new CoreKaro();
        player1 = new PlayerKaro();
        player2 = new PlayerKaro();
        this.value = 0;
        this.row = 0;
        this.col = 0;
    }         
}
