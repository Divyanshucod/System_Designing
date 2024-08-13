package GameMain;

import Checks.PathValidation;
import GameBoard.Board;
import PlayerAndPieces.CreatePieces;
import PlayerAndPieces.Players;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class Game {
    Deque<Players>deq = new ArrayDeque<>();
    Board board;
    PathValidation pathObject = null;
    Players p1 = null;
    Players p2 = null;
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
        forp2.createPieces();
        forp1.createPieces();
        // players

        this.p1 = new Players(forp1,name,color);
        this.p2 = new Players(forp2,name2,color2);

        board.printBoard();
        if(color2.equals("white")){
            deq.addLast(p2);
            deq.addLast(p1);
        }
        if(color2.equals("black")){
            deq.addLast(p1);
            deq.addLast(p2);
        }
        pathObject = new PathValidation();
        startGame();
    }
    public String startGame(){
        while(true){
            Players player = deq.getFirst();
            System.out.println("Hi! "+player.getname()+" your turn!");
            System.out.println("Enter starting row: ");
            Scanner scanner = new Scanner(System.in);
            int currRow = scanner.nextInt();
            scanner.nextLine();
            System.out.println("Enter starting column: ");
            int currCol = scanner.nextInt();
            scanner.nextLine();System.out.println("Enter ending row: ");
            int destRow = scanner.nextInt();
            scanner.nextLine();System.out.println("Enter ending column: ");
            int destCol = scanner.nextInt();
            scanner.nextLine();
            if(board.ValidatePositions(currRow,currCol,destRow,destCol)){
                //path validation
                boolean res = pathObject.PathValidations(this.board, currRow, currCol, destRow, destCol, player.getPieceColorBoolean());
                if(res){
                    this.board.movePieces(currRow,currCol,destRow,destCol);
                    System.out.println("Move is updated");
                    this.board.printBoard();
                }
                else{
                    System.out.println("Invalid Move!");
                    deq.addFirst(p1);
                    continue;
                }
                //check your king is getting cheque
                boolean result = pathObject.checkKingGettingCheck(17,17,board, !player.getPieceColorBoolean());
                if(result){
                    if(player.getPieceColorBoolean()){
                        System.out.println("Hi! "+p1.getname()+" You are getting Check!");
                    }
                    else{
                        System.out.println("Hi! "+p2.getname()+" You are getting Check!");
                    }
                }
                // check check-mate
                 result = pathObject.checkCheckMate(board, !player.getPieceColorBoolean());
                 if(result){
                    if(player.getPieceColorBoolean()){
                        System.out.println("Hi! "+p1.getname()+" You lose the game!");
                    }
                    else{
                        System.out.println("Hi! "+p2.getname()+" You lose the game!");
                    }
                }
            }
            else{
                deq.addFirst(p1);
            }
        }
    }

}
