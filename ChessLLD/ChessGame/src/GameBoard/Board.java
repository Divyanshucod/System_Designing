package GameBoard;

import PlayerAndPieces.Piece;
import PlayerAndPieces.PieceType;

import java.util.HashMap;

public class Board {
    int size = 0;
    Piece[][] board;
    HashMap<PieceType,String>listOfPiecesOnBoard;
    public Board(int size){
        this.size = size;
        this.board = new Piece[size][size];
        listOfPiecesOnBoard = new HashMap<>();
        mapPieces();
    }
    public void createBoard(){
        // arrange piece at their specific positions
        //pawns arrangement
        for(int i=0;i<8;i++){
            board[1][i] = new Piece(PieceType.BP);
            board[6][i] = new Piece(PieceType.WP);
        }
        //rooks
        board[0][0] = new Piece(PieceType.BR);
        board[0][7] = new Piece(PieceType.BR);
        board[7][7] = new Piece(PieceType.WR);
        board[7][0] = new Piece(PieceType.WR);
        //bishops
        board[0][1] = new Piece(PieceType.BB);
        board[0][6] = new Piece(PieceType.BB);
        board[7][6] = new Piece(PieceType.WB);
        board[7][1] = new Piece(PieceType.WB);
        //knights
        board[0][2] = new Piece(PieceType.Bk);
        board[0][5] = new Piece(PieceType.Bk);
        board[7][5] = new Piece(PieceType.Wk);
        board[7][2] = new Piece(PieceType.Wk);
        //king
        board[0][4] = new Piece(PieceType.BK);
        board[7][4] = new Piece(PieceType.WK);
        //queen
        board[0][3] = new Piece(PieceType.BQ);
        board[7][3] = new Piece(PieceType.WQ);
    }
    public boolean movePieces(int currRow,int currCol,int destRow,int destCol){
        if(ValidatePositions(currRow,currCol,destRow,destCol)){
            Piece piece = board[currRow][currCol];
            board[currRow][currCol] = null;
            board[destRow][destCol] = piece;
        }
        else{
            System.out.println("Invalid Positions!");
            return false;
        }
        return true;
    }
    public boolean ValidatePositions(int currRow,int currCol,int destRow,int destCol){
        return (currRow >= 0 && currRow < size && currCol >= 0 && currCol < size && destRow >= 0 && destCol < size);
    }
    public void printBoard(){
        for(int i=0;i<8;i++){
            for (int j=0;j<8;j++){
                if(board[i][j] != null){
                    System.out.print("| "+listOfPiecesOnBoard.get(board[i][j].getTroop())+" |");
                }
                else{
                    System.out.print("|    |");
                }
            }
            System.out.println();
        }
    }
    public Piece getPiece(int row,int col){
        if(row >= 0 && row < 8 && col >=0 && col < 8){
            return board[row][col];
        }
        System.out.println("No Piece Exist");
        return null;
    }
    public int getSize(){
        return this.size;
    }
    void mapPieces(){
        listOfPiecesOnBoard.put(PieceType.BK,"BK");
        listOfPiecesOnBoard.put(PieceType.BB,"BB");
        listOfPiecesOnBoard.put(PieceType.BP,"BP");
        listOfPiecesOnBoard.put(PieceType.BR,"BR");
        listOfPiecesOnBoard.put(PieceType.Bk,"Bk");
        listOfPiecesOnBoard.put(PieceType.BQ,"BQ");
        listOfPiecesOnBoard.put(PieceType.WP,"WP");
        listOfPiecesOnBoard.put(PieceType.WR,"WR");
        listOfPiecesOnBoard.put(PieceType.WB,"WB");
        listOfPiecesOnBoard.put(PieceType.WQ,"WQ");
        listOfPiecesOnBoard.put(PieceType.Wk,"Wk");
        listOfPiecesOnBoard.put(PieceType.WK,"WK");
    }
}
