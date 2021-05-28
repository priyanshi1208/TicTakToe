
import java.util.Random;
import java.util.Scanner;

public class TicTacToe {
    char[] currentBoard;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String playAgain;
        do {
            TicTacToe ticTacToe = new TicTacToe();
            char[] currentboard = ticTacToe.board();
            ticTacToe.showBoard(currentboard);
            System.out.println("Choose your letter between X and O");
            char playerLetter = scanner.next().charAt(0);
            char computerLetter = ticTacToe.computerLetter(playerLetter);
            System.out.println("Computer's letter:" + computerLetter +", "+ "Your letter:" + playerLetter);
            System.out.println("Toss who will play first,Press T to toss the coin");
            char toss=scanner.next().charAt(0);
            int turn = ticTacToe.turn();
            if (turn == 1) {
                System.out.println("Your turn first");
                System.out.println("Choose an Index between 1-9");
                int index = scanner.nextInt();
                ticTacToe.availableIndex(index, playerLetter);
                ticTacToe.showBoard(currentboard);
                System.out.println("Turn changed");
                System.out.println();
                turn = 0;
            } else if (turn == 0) {
                System.out.println("Computer's turn first");
                ticTacToe.computerInput(currentboard, computerLetter, playerLetter);
                ticTacToe.showBoard(currentboard);
                System.out.println("Turn changed");
                System.out.println();
                turn = 1;
            }
            boolean result=true;
            while(result){
                if(turn==1){
                    System.out.println("Choose a index between 1-9");
                    int index=scanner.nextInt();
                    boolean indexNotFree=ticTacToe.availableIndex(index,playerLetter);
                    if(!indexNotFree) {
                        System.out.println("Index not free choose again between 1-9");
                        int index1 = scanner.nextInt();
                        ticTacToe.availableIndex(index1,playerLetter);
                    }
                    ticTacToe.showBoard(currentboard);
                    System.out.println("Turn changed");
                    System.out.println();
                    result=ticTacToe.winner(currentboard,playerLetter);
                    if(!result)
                        System.out.println("Game Over");
                    turn=0;
                }
                else {
                    ticTacToe.computerInput(currentboard,computerLetter,playerLetter);
                    ticTacToe.showBoard(currentboard);
                    System.out.println("Turn changed");
                    System.out.println();
                    result=ticTacToe.winner(currentboard,computerLetter);
                    if(!result)
                        System.out.println("Game Over");
                    turn=1;
                }
            }
            System.out.println("If you want to play again press Yes");
            playAgain=scanner.next();
        }while(playAgain.equalsIgnoreCase("Yes"));


    }
    //UC1
   public char[] board(){
        char[] currentBoard=new char[10];
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
    public void showBoard(char[] currentBoard){

        System.out.println(currentBoard[1] +" |"+currentBoard[2]+"  |"+currentBoard[3]);
        System.out.println("-------------");
        System.out.println(currentBoard[4] +" |"+currentBoard[5]+"  |"+currentBoard[6]);
        System.out.println("-------------");
        System.out.println(currentBoard[7] +" |"+currentBoard[8]+"  |"+currentBoard[9]);
    }
    //UC4

    public boolean availableIndex(int index,char playerLetter){
            if(move(index)) {
                currentBoard[index] = playerLetter;
                return true;
            }
            else
                return false;
    }
    public boolean move(int index){
        if(currentBoard[index]==' ')
            return true;
        else
            return false;
    }
    public boolean checkWin(char[] currentBoard,char letter,int position){
        char[] temp=new char[10];
        for(int i=1;i<10;i++)
            temp[i]=currentBoard[i];
        temp[position]=letter;
        return winCondition(letter,temp);
    }
    public boolean winCondition(char letter,char[] Board){
        return (Board[1] == letter && Board[1] == Board[2] && Board[2] == Board[3] ||
                Board[4] == letter && Board[4] == Board[5] && Board[5] == Board[6] ||
                Board[7] == letter && Board[7] == Board[8] && Board[8] == Board[9] ||
                Board[1] == letter && Board[1] == Board[4] && Board[4] == Board[7] ||
                Board[2] == letter && Board[2] == Board[5] && Board[5] == Board[8] ||
                Board[3] == letter && Board[3] == Board[6] && Board[6] == Board[9] ||
                Board[1] == letter && Board[1] == Board[5] && Board[5] == Board[9] ||
                Board[3] == letter && Board[3] == Board[5] && Board[5] == Board[7]);
    }
    public char[] computerInput(char[] currentBoard,char computerLetter, char playerLetter){
        for(int i=1;i<10;i++){
            if(currentBoard[i]==' '&& checkWin(currentBoard,computerLetter,i)){
                currentBoard[i]=computerLetter;
                return currentBoard;
            }
        }
        for(int i=1;i<10;i++){
            if(currentBoard[i]==' ' && checkWin(currentBoard,playerLetter,i)) {
                currentBoard[i] = computerLetter;
                return currentBoard;
            }
        }
        if(currentBoard[1] == ' ') {
            currentBoard[1] = computerLetter;
            return currentBoard;
        }
        if(currentBoard[3] == ' ') {
            currentBoard[3] = computerLetter;
            return currentBoard;
        }
        if(currentBoard[7] == ' ') {
            currentBoard[7] = computerLetter;
            return currentBoard;
        }
        if(currentBoard[9] == ' ') {
            currentBoard[9] = computerLetter;
            return currentBoard;
        }
        if(currentBoard[5] == ' ') {
            currentBoard[5] = computerLetter;
            return currentBoard;
        }
        if(currentBoard[2] == ' ') {
            currentBoard[2] = computerLetter;
            return currentBoard;
        }
        if(currentBoard[4] == ' ') {
            currentBoard[4] = computerLetter;
            return currentBoard;
        }
        if(currentBoard[6] == ' ') {
            currentBoard[6] = computerLetter;
            return currentBoard;
        }
        if(currentBoard[8] == ' ') {
            currentBoard[8] = computerLetter;
            return currentBoard;
        }
      return currentBoard;
    }

    public int turn(){
      return new Random().nextInt(2);
    }
    public boolean gameDraw(char[] currentBoard){
        boolean count=true;
        for(int i=1;i<currentBoard.length;i++) {
            if (currentBoard[i] == ' ') {
                count = false;
                break;
            }
        }
       return count;
    }

    public boolean winner(char[] currentBoard,char letter) {
       if(gameDraw(currentBoard)) {
           System.out.println("Game Drawn");
           return false;
       }
       else if(winCondition(letter,currentBoard)){
           System.out.println("Player "+letter+" Won");
           return false;
       }
       else{
           return true;
       }

    }
}
