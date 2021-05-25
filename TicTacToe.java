
import java.util.Scanner;

public class TicTacToe {
    char[] currentBoard;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TicTacToe ticTacToe=new TicTacToe();
        ticTacToe.board();
        System.out.println("choose your letter between X and O");
        char letter = scanner.next().charAt(0);
        System.out.println("Computer's letter:"+ticTacToe.computerLetter(letter)+"Your letter:"+letter);
        ticTacToe.showBoard();

    }
    //UC1
   public void board(){
        char[] currentBoard=new char[10];
       System.out.println(currentBoard.length);
        for(int i=1;i<currentBoard.length;i++)
        {
            currentBoard[i]=' ';
        }
        this.currentBoard=currentBoard;
       System.out.println("New Board Created");
    }
    //UC2
    public char computerLetter(char letter) {
        return  (letter == 'X') ? 'O' : 'X';
    }
    //UC3
    public void showBoard(){
        char[] board=currentBoard;
        for(int i=1;i<board.length;i++){
            System.out.println("Position "+"i:"+board[i]);
        }
    }
}
