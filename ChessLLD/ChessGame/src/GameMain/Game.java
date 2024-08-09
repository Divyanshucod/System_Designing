package GameMain;

import GameBoard.Board;
import PlayerAndPieces.CreatePieces;
import PlayerAndPieces.Players;

import java.util.Deque;
import java.util.Scanner;

public class Game {
    Deque<Players>deq;
    Board board;

    public Game(int size){
        initialization(size);
    }
    public void initialization(int size){
        this.board = new Board(size);
        System.out.println("-----------WELCOME TO CHESS GAME!-----------");
        System.out.println("Player first Choose Color: Ex. black or white");
        Scanner scanner = new Scanner(System.in);
        String color = scanner.nextLine();
        System.out.println("Player first Enter Your Name: Ex. rahul");
        String name = scanner.nextLine();
        System.out.println("Player second Enter Your Name: Ex. rahul");
        String name2 = scanner.nextLine();
        String color2 = color.equals("black") ? "white" : "black";
        System.out.println("Player first Name -> "+name+" Color: "+color);
        System.out.println("Player second Name -> "+name2+" Color: "+color2);
        //piece creation
        CreatePieces forp1 = new CreatePieces(color.toUpperCase().charAt(0));
        CreatePieces forp2 = new CreatePieces(color2.toUpperCase().charAt(0));
        // players

        Players p1 = new Players(forp1,name,color);
        Players p2 = new Players(forp2,name2,color2);
        board.printBoard();
        if(color2.equals("white")){
            deq.addLast(p2);
            deq.addLast(p1);
        }
        if(color2.equals("black")){
            deq.addLast(p1);
            deq.addLast(p2);
        }
        startGame();
    }
    public String startGame(){
        while(true){
            Players p1 = deq.getFirst();
            System.out.println("Hi! "+p1.getname()+" your turn!");
            System.out.println("Enter starting row: ");
            Scanner scanner = new Scanner(System.in);
            int startRow = scanner.nextInt();
            scanner.nextLine();
            System.out.println("Enter starting column: ");
            int startCol = scanner.nextInt();
            scanner.nextLine();System.out.println("Enter ending row: ");
            int endRow = scanner.nextInt();
            scanner.nextLine();System.out.println("Enter ending column: ");
            int endCol = scanner.nextInt();
            scanner.nextLine();
            if(board.ValidatePositions(startRow,startCol,endRow,endCol)){
                // checks -> pathvalidation and checking check/ check-mate
                //pathValidation if return push same player at first for again movement.
            }
            else{
                deq.addFirst(p1);
            }
        }
    }

}
