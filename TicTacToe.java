
import java.util.ArrayList;
import java.util.Scanner;

public class TicTacToe {
    char[] currentBoard;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TicTacToe ticTacToe=new TicTacToe();
        ticTacToe.board();

    }
    //UC1
   public char[] board(){
        char[] currentBoard=new char[10];
       System.out.println(currentBoard.length);
        for(int i=1;i<currentBoard.length-1;i++)
        {
            currentBoard[i]=' ';
        }
        this.currentBoard=currentBoard;
        return currentBoard;
    }
}
