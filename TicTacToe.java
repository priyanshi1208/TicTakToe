
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class TicTacToe {
    char[] currentBoard;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TicTacToe ticTacToe=new TicTacToe();
        ticTacToe.board();
        System.out.println("Choose your letter between X and O");
        char letter = scanner.next().charAt(0);
        char computerLetter=ticTacToe.computerLetter(letter);
        System.out.println("Computer's letter:"+computerLetter+"Your letter:"+letter);
        System.out.println("Toss who will play first");
        ticTacToe.turn();
        System.out.println("Enter a index to navigate in");
        int index=scanner.nextInt();
        ticTacToe.availableIndex(index,letter);

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

    public void availableIndex(int index,char letter){
        ArrayList<Integer> indexlist=new ArrayList<>();
        for(int i=1;i<=board().length;i++){
            indexlist.add(i);
        }
        indexlist.forEach(System.out::println);
        int status;
        if(indexlist.contains(index)) {
            if(move(index)==1)
                currentBoard[index]=placeMove(letter);
            else
                System.out.println("Index not Empty choose another");

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
    public char placeMove(char playerletter,char computerletter){
        if(turn()==1)
            return playerletter;
        else
            return computerletter;
    }
    public int turn(){
      return new Random().nextInt(2);
     
    }
}
