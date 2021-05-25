
import java.util.ArrayList;
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
        System.out.println("Enter a index to navigate in");
        int index=scanner.nextInt();
        ticTacToe.availableIndex(index);

    }
    //UC1
   public char[] board(){
        char[] currentBoard=new char[10];
       System.out.println(currentBoard.length);
        for(int i=1;i<currentBoard.length;i++)
        {
            currentBoard[i]=' ';
        }
        this.currentBoard=currentBoard;
       System.out.println("New Board Created");
       return currentBoard;
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
    //UC4

    public void availableIndex(int index){
        ArrayList<Integer> indexlist=new ArrayList<>();
        for(int i=1;i<=board().length;i++){
            indexlist.add(i);
        }
        indexlist.forEach(System.out::println);
        String status;
        if(indexlist.contains(index)) {
            status = (move(index) == 0) ? "Index is not vacant choose again" : "Moved To vacant Index";
            System.out.println(status);
        }
        else
            System.out.println("Invalid index");
    }
    public int move(int index){

        int currentIndex;
        if(currentBoard[index]==' ')
            currentIndex = 1;
        else
            currentIndex=0;
        return currentIndex;
    }
}
