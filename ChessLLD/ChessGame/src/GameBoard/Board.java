package GameBoard;

import PlayerAndPieces.Piece;
import PlayerAndPieces.PieceType;

public class Board {
    int size = 0;
    Piece[][] board;
    public Board(int size){
        this.size = size;
        this.board = new Piece[size][size];
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
        board[0][2] = new Piece(PieceType.Bkn);
        board[0][5] = new Piece(PieceType.Bkn);
        board[7][5] = new Piece(PieceType.Wkn);
        board[7][2] = new Piece(PieceType.Wkn);
        //king
        board[0][4] = new Piece(PieceType.BKi);
        board[7][4] = new Piece(PieceType.WKi);
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
                System.out.println(board[i][j].getTroop());
            }
        }
    }
    public Piece getPiece(int row,int col){
        if(row >= 0 && row < 8 && col >=0 && col < 8){
            return board[row][col];
        }
        System.out.println("No Piece Exist");
        return null;
    }
}
