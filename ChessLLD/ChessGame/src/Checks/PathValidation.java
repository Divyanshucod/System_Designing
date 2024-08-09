package Checks;

import GameBoard.Board;
import PlayerAndPieces.PieceType;

public class PathValidation {
    public boolean PathValidations(Board board,int currRow,int currCol,int endRow,int endCol,boolean blackOrWhite){
        switch (board.getPiece(currRow,currCol).getTroop()){
            case BP:
                return validatePawnMove(board,currRow,currCol,endRow,endCol,blackOrWhite);
            case WP:
                return validatePawnMove(board,currRow,currCol,endRow,endCol,blackOrWhite);
            case BB:
                return validateBishopMove(board,currRow,currCol,endRow,endCol,blackOrWhite);
            case WB:
                return validateBishopMove(board,currRow,currCol,endRow,endCol,blackOrWhite);
            case BR:
                return validateRookMove(board,currRow,currCol,endRow,endCol,blackOrWhite);
            case WR:
                return validateRookMove(board,currRow,currCol,endRow,endCol,blackOrWhite);
            case Bkn:
                return validateKnightMove(board,currRow,currCol,endRow,endCol,blackOrWhite);
            case Wkn:
                return validateKnightMove(board,currRow,currCol,endRow,endCol,blackOrWhite);
            case BKi:
                return validateKingMove(board,currRow,currCol,endRow,endCol,blackOrWhite);
            case WKi:
                return validateKingMove(board,currRow,currCol,endRow,endCol,blackOrWhite);
        }
        return false;
    }
    public boolean validatePawnMove(Board board,int currRow,int currCol,int endRow,int endCol,boolean blackOrWhite){
        return false;
    }
    public boolean validateBishopMove(Board board,int currRow,int currCol,int endRow,int endCol,boolean blackOrWhite){
        return false;
    }
    public boolean validateRookMove(Board board,int currRow,int currCol,int endRow,int endCol,boolean blackOrWhite){
        return false;
    }
    public boolean validateKnightMove(Board board,int currRow,int currCol,int endRow,int endCol,boolean blackOrWhite){
        int delrow[] = {-2,-1,-2,-1,1,2,2,1};
        int delcol[] = {-1,-2,1,2,2,1,-1,-2};
        for(int i=0;i<8;i++){
            int nrow = currRow+delrow[i];
            int ncol = currCol+delcol[i];
            if(validatePosition(nrow,ncol,board,blackOrWhite,endRow,endCol)){
                return true;
            }
        }
        return false;
    }
    public boolean validateKingMove(Board board,int currRow,int currCol,int endRow,int endCol,boolean blackOrWhite){
        return false;
    }
    public boolean validatePosition(int nrow,int ncol,Board board,boolean blackOrWhite,int endRow,int endCol){
        if(nrow < 0 || nrow >= 8 || ncol < 0 || ncol >= 8 || pieceCheck(blackOrWhite,board,nrow,ncol))
        {
            return false;
        }
        return (nrow == endRow && ncol == endCol);
    }
    public boolean pieceCheck(boolean blackOrWhite,Board board,int nrow,int ncol){
        PieceType piece = board.getPiece(nrow,ncol).getTroop();
        if(blackOrWhite){
            return (piece == PieceType.WB || piece == PieceType.WP ||
                    piece == PieceType.Wkn || piece == PieceType.WKi || piece == PieceType.WR || piece == PieceType.WQ);
        }
        else{
            return (piece == PieceType.BB || piece == PieceType.BP ||
                    piece == PieceType.Bkn || piece == PieceType.BKi || piece == PieceType.BR || piece == PieceType.BQ);
        }

    }
}
