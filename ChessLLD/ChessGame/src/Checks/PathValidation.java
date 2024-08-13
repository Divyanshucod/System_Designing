package Checks;

import GameBoard.Board;
import PlayerAndPieces.PieceType;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class PathValidation {
    HashMap<Boolean,List<Integer>>KingsPosition = new HashMap<>();
    public PathValidation(){
        KingsPosition.put(true,new ArrayList<>(Arrays.asList(7,4)));
        KingsPosition.put(false,new ArrayList<>(Arrays.asList(0,4)));
    }
    public boolean PathValidations(Board gameBoard,int pieceCurrRow,int pieceCurrCol,int pieceDestRow,int pieceDestCol,boolean pieceColor){
        return switch (gameBoard.getPiece(pieceCurrRow, pieceCurrCol).getTroop()) {
            case BP, WP -> validatePawnMove(gameBoard, pieceCurrRow, pieceCurrCol, pieceDestRow, pieceDestCol, pieceColor);
            case BB, WB -> validateBishopMove(gameBoard, pieceCurrRow, pieceCurrCol, pieceDestRow, pieceDestCol, pieceColor);
            case BR, WR -> validateRookMove(gameBoard, pieceCurrRow, pieceCurrCol, pieceDestRow, pieceDestCol, pieceColor);
            case Bkn, Wkn -> validateKnightMove(gameBoard, pieceCurrRow, pieceCurrCol, pieceDestRow, pieceDestCol, pieceColor);
            case BKi, WKi -> validateKingMove(gameBoard, pieceCurrRow, pieceCurrCol, pieceDestRow, pieceDestCol, pieceColor);
            case WQ, BQ -> validateQueenMove(gameBoard, pieceCurrRow, pieceCurrCol, pieceDestRow, pieceDestCol, pieceColor);
        };
    }
    public boolean validatePawnMove(Board gameBoard,int pawnCurrRow,int pawnCurrCol,int pawnDestRow,int pawnDestCol,boolean pieceColor){
        // Pawn can move in two ways either straight or diagonal but one step at a time. and diagonal only when you have
        // A opponent piece on that cell other-wise only one option to move is straight.
        int[] delrowForBlack = {1,1,1};
        int[] delcolForBlack = {-1,0,1};
        int[] delrowForWhite = {-1,-1,-1};
        int[] delcolForWhite = {-1,0,1};
        for(int i=0;i<3;i++){
            int nrow = pieceColor ? pawnCurrRow+delrowForWhite[i] : pawnCurrRow+delrowForBlack[i];
            int newCol = pieceColor ? pawnCurrCol+delcolForWhite[i] : pawnCurrCol+delcolForBlack[i];
            if(i==1 && validatePosition(nrow,newCol,gameBoard,pieceColor,pawnDestRow,pawnDestCol)){
                //check king will get check if you move this piece to do that move this piece temporary and check via (checking) check function
                return checkKingIndirectCheck(pawnCurrRow, pawnCurrCol, pawnDestRow, pawnDestCol, gameBoard, pieceColor);
            }
            else if(i!=1 && validatePieceEliminationViaPawn(nrow,newCol,gameBoard,pieceColor,pawnDestRow,pawnDestCol)){
                return checkKingIndirectCheck(pawnCurrRow, pawnCurrCol, pawnDestRow, pawnDestCol, gameBoard, pieceColor);
            }
        }
        return false;
    }
    public boolean validateBishopMove(Board gameBoard,int bishopCurrRow,int bishopCurrCol,int bishopDestRow,int bishopDestCol,boolean pieceColor){
        // Bishop movement check for rightDiagonally
        boolean res1 = checkRightDiagonalMovement(gameBoard,bishopCurrRow,bishopCurrCol,bishopDestRow,bishopDestCol,pieceColor);
        boolean res2 = checkLeftDiagonalMovement(gameBoard,bishopCurrRow,bishopCurrCol,bishopDestRow,bishopDestCol,pieceColor);
        if(res2 || res1){
            return checkKingIndirectCheck(bishopCurrRow, bishopCurrCol, bishopDestRow, bishopDestCol, gameBoard, pieceColor);
        }
        return false;
    }
    public boolean validateRookMove(Board gameBoard,int rookCurrRow,int rookCurrCol,int rookDestRow,int rookDestCol,boolean pieceColor){
        boolean res1 = checkHorizontalMovement(gameBoard,rookCurrRow,rookCurrCol,rookDestRow,rookDestCol,pieceColor);
        boolean res2 = checkVerticalMovement(gameBoard,rookCurrRow,rookCurrCol,rookDestRow,rookDestCol,pieceColor);
        if(res2 || res1){
            return checkKingIndirectCheck(rookCurrRow, rookCurrCol, rookDestRow, rookDestCol, gameBoard, pieceColor);
        }
        return false;
    }
    public boolean validateKnightMove(Board gameBoard,int knightCurrRow,int knightCurrCol,int knightDestRow,int knightDestCol,boolean pieceColor){
        int[] delrow = {-2,-1,-2,-1,1,2,2,1};
        int[] delcol = {-1,-2,1,2,2,1,-1,-2};
        for(int i=0;i<8;i++){
            int nrow = knightCurrRow+delrow[i];
            int newCol = knightCurrCol+delcol[i];
            if(validatePosition(nrow,newCol,gameBoard,pieceColor,knightDestRow,knightDestCol)){
                return checkKingIndirectCheck(knightCurrRow, knightCurrCol, knightDestRow, knightDestCol, gameBoard, pieceColor);
            }
        }
        return false;
    }
    public boolean validateKingMove(Board gameBoard,int kingCurrRow,int kingCurrCol,int kingDestRow,int kingDestCol,boolean pieceColor){
        int[] delrow = {-1,-1,-1,0,0,1,1,1};
        int[] delcol = {-1,0,1,-1,1,-1,0,1};
          for(int i=0;i<8;i++){
            int nrow = kingCurrRow+delrow[i];
            int newCol = kingCurrCol+delcol[i];
            if(validatePosition(nrow,newCol,gameBoard,pieceColor,kingDestRow,kingDestCol)){
                KingsPosition.put(pieceColor,new ArrayList<>(Arrays.asList(kingDestRow,kingDestCol)));
                if(!checkKingGettingCheck(kingDestRow, kingDestCol, gameBoard, pieceColor)){
                    return true;
                }
                KingsPosition.put(pieceColor,new ArrayList<>(Arrays.asList(kingCurrRow,kingCurrCol)));
            }
        }
        return false;
    }
    public boolean validateQueenMove(Board gameBoard,int queenCurrRow,int queenCurrCol,int queenDestRow,int queenDestCol,boolean pieceColor){
        boolean res =  checkRightDiagonalMovement(gameBoard,queenCurrRow,queenCurrCol,queenDestRow,queenDestCol,pieceColor);
        boolean res2 = checkLeftDiagonalMovement(gameBoard,queenCurrRow,queenCurrCol,queenDestRow,queenDestCol,pieceColor);
        boolean res3 = checkHorizontalMovement(gameBoard,queenCurrRow,queenCurrCol,queenDestRow,queenDestCol,pieceColor);
        boolean res4 = checkVerticalMovement(gameBoard,queenCurrRow,queenCurrCol,queenDestRow,queenDestCol,pieceColor);
        if(res || res2 || res3 || res4){
            return checkKingIndirectCheck(queenCurrRow, queenCurrCol, queenDestRow, queenDestCol, gameBoard, pieceColor);
        }
        return false;
    }
    public boolean validatePosition(int pieceCurrRow,int pieceCurrCol,Board gameBoard,boolean pieceColor,int pieceDestRow,int pieceDestCol){
        if(pieceCurrRow < 0 || pieceCurrRow >= 8 || pieceCurrCol < 0 || pieceCurrCol >= 8 || pieceCheck(pieceColor,gameBoard,pieceCurrRow,pieceCurrCol))
        {
            return false;
        }
        return (pieceCurrRow == pieceDestRow && pieceCurrCol == pieceDestCol);
    }
    public boolean pieceCheck(boolean pieceColor,Board gameBoard,int newRow,int newCol){
        PieceType piece = gameBoard.getPiece(newRow,newCol).getTroop();
        if(pieceColor){
            return (piece == PieceType.WB || piece == PieceType.WP ||
                    piece == PieceType.Wkn || piece == PieceType.WKi || piece == PieceType.WR || piece == PieceType.WQ);
        }
        else{
            return (piece == PieceType.BB || piece == PieceType.BP ||
                    piece == PieceType.Bkn || piece == PieceType.BKi || piece == PieceType.BR || piece == PieceType.BQ);
        }

    }
    public boolean checkRightDiagonalMovement(Board gameBoard,int pieceCurrRow,int pieceCurrCol,int pieceDestRow,int pieceDestCol,boolean pieceColor){
        int row = pieceCurrRow+1;
        int col = pieceCurrCol+1;
        while(row<gameBoard.getSize() && row >=0 && col>=0 && col<gameBoard.getSize()){
            if(validatePosition(row,col,gameBoard,pieceColor,pieceDestRow,pieceDestCol)){
                return true;
            }
            row++;
            col++;
        }
         row = pieceCurrRow-1;
         col = pieceCurrCol-1;
        while(row<gameBoard.getSize() && row >=0 && col>=0 && col<gameBoard.getSize()){
            if(validatePosition(row,col,gameBoard,pieceColor,pieceDestRow,pieceDestCol)){
                return true;
            }
            row--;
            col--;
        }
        return false;
    }
    public boolean checkLeftDiagonalMovement(Board gameBoard,int pieceCurrRow,int pieceCurrCol,int pieceDestRow,int pieceDestCol,boolean pieceColor){
        int row = pieceCurrRow-1;
        int col = pieceCurrCol+1;
        while(row<gameBoard.getSize() && row >=0 && col>=0 && col<gameBoard.getSize()){
            if(validatePosition(row,col,gameBoard,pieceColor,pieceDestRow,pieceDestCol)){
                return true;
            }
            row--;
            col++;
        }
        row = pieceCurrRow+1;
        col = pieceCurrCol-1;
        while(row<gameBoard.getSize() && row >=0 && col>=0 && col<gameBoard.getSize()){
            if(validatePosition(row,col,gameBoard,pieceColor,pieceDestRow,pieceDestCol)){
                return true;
            }
            row++;
            col--;
        }
        return false;
    }
    public boolean checkHorizontalMovement(Board gameBoard,int pieceCurrRow,int pieceCurrCol,int pieceDestRow,int pieceDestCol,boolean pieceColor){
        int col = pieceCurrCol-1;
        while(col>=0 && col<gameBoard.getSize()){
            if(validatePosition(pieceCurrRow,col,gameBoard,pieceColor,pieceDestRow,pieceDestCol)){
                return true;
            }
            col--;
        }
        col = pieceCurrCol+1;
        while(col>=0 && col<gameBoard.getSize()){
            if(validatePosition(pieceCurrRow,col,gameBoard,pieceColor,pieceDestRow,pieceDestCol)){
                return true;
            }
            col++;
        }
        return false;
    }
    public boolean checkVerticalMovement(Board gameBoard,int pieceCurrRow,int pieceCurrCol,int pieceDestRow,int pieceDestCol,boolean pieceColor){
        int row = pieceCurrRow-1;
        while( row>=0 && row<gameBoard.getSize()){
            if(validatePosition(row,pieceCurrCol,gameBoard,pieceColor,pieceDestRow,pieceDestCol)){
                return true;
            }
            row--;
        }
        row = pieceCurrRow+1;
        while(row<gameBoard.getSize() && row >=0){
            if(validatePosition(row,pieceCurrCol,gameBoard,pieceColor,pieceDestRow,pieceDestCol)){
                return true;
            }
            row++;
        }
        return false;
    }
    public boolean validatePieceEliminationViaPawn(int newRow,int newCol,Board gameBoard,boolean pieceColor,int pieceDestRow,int pieceDestCol){
        if(newRow >= 0 && newRow < 8 && newCol >= 0 && newCol < 8 && pawnMoveCheck(pieceColor,gameBoard,newRow,newCol))
        {
            return (newRow == pieceDestRow && newCol == pieceDestCol);
        }
        return false;
    }
    public boolean pawnMoveCheck(boolean pieceColor,Board gameBoard,int newRow,int newCol){
        PieceType piece = gameBoard.getPiece(newRow,newCol).getTroop();
        if(pieceColor){
            return (piece == PieceType.BB || piece == PieceType.BP ||
                    piece == PieceType.Bkn || piece == PieceType.BKi || piece == PieceType.BR || piece == PieceType.BQ);
        }
        else{
            return (piece == PieceType.WB || piece == PieceType.WP ||
                    piece == PieceType.Wkn || piece == PieceType.WKi || piece == PieceType.WR || piece == PieceType.WQ);
        }

    }
    public boolean checkKingGettingCheck(int row,int col,Board gameBoard,boolean pieceColor){
        //via bishop
        if(row == 17 && col == 17){
            List<Integer>kingsPos = KingsPosition.get(pieceColor);
            row = kingsPos.get(0);
            col = kingsPos.get(1);
        }
        boolean res1 = bishopOrQueenCheck(row,col,gameBoard,pieceColor);
        //via rook
        boolean res2 =  rookOrQueenCheck(row,col,gameBoard,pieceColor);
        //via knight
        boolean res3 = knightCheck(row,col,gameBoard,pieceColor);
        //via pawn
        boolean res4 = pawnCheck(row,col,gameBoard,pieceColor);
        //via king
        boolean res5 = kingCheck(row,col,gameBoard,pieceColor);
        return (res1 || res2 || res3 || res4 || res5);
    }
    public boolean bishopOrQueenCheck(int row,int col,Board gameBoard,boolean pieceColor){
        //check right diagonally
        //right up
        int r = row-1;
        int c = col+1;
        while(r >= 0 && r< gameBoard.getSize() && c >=0 && c <gameBoard.getSize()){
            if(isKingGettingCheck(r,c,gameBoard,pieceColor,"bishop")){
                return true;
            }
            r--;
            c++;
        }
        //right down
        r = row+1;
         c = col-1;
        while(r >= 0 && r< gameBoard.getSize() && c >=0 && c <gameBoard.getSize()){
            if(isKingGettingCheck(r,c,gameBoard,pieceColor,"bishop")){
                return true;
            }
            r++;
            c--;
        }
        //left up
         r = row-1;
         c = col-1;
        while(r >= 0 && r< gameBoard.getSize() && c >=0 && c <gameBoard.getSize()){
            if(isKingGettingCheck(r,c,gameBoard,pieceColor,"bishop")){
                return true;
            }
            r--;
            c--;
        }
        //left down
        r = row-1;
        c = col-1;
        while(r >= 0 && r< gameBoard.getSize() && c >=0 && c <gameBoard.getSize()){
            if(isKingGettingCheck(r,c,gameBoard,pieceColor,"bishop")){
                return true;
            }
            r++;
            c++;
        }

        return false;
    }
    public boolean isKingGettingCheck(int row,int col,Board gameBoard,boolean pieceColor,String type){
        PieceType piece = gameBoard.getPiece(row,col).getTroop();
        if(pieceColor && piece != null){
            switch (type) {
                case "bishop" -> {
                    return (piece == PieceType.BB || piece == PieceType.BQ);
                }
                case "rook" -> {
                    return (piece == PieceType.BR || piece == PieceType.BQ);
                }
                case "pawn" -> {
                    return (piece == PieceType.BP);
                }
                case "king" -> {
                    return (piece == PieceType.BKi);
                }
                case "knight" -> {
                    return (piece == PieceType.Bkn);
                }
            }
        }
        else if(!pieceColor && piece != null){
            switch (type) {
                case "bishop" -> {
                    return (piece == PieceType.WB || piece == PieceType.WQ);
                }
                case "rook" -> {
                    return (piece == PieceType.WR || piece == PieceType.WQ);
                }
                case "pawn" -> {
                    return (piece == PieceType.WP);
                }
                case "king" -> {
                    return (piece == PieceType.WKi);
                }
                case "knight" -> {
                    return (piece == PieceType.Wkn);
                }
            }
        }
        return false;
    }
    public boolean rookOrQueenCheck(int row,int col,Board gameBoard,boolean pieceColor){
        //Horizontal check
        int c = col-1;
        while(c>=0 && c<gameBoard.getSize()){
            if(isKingGettingCheck(row,c,gameBoard,pieceColor,"rook")){
                return true;
            }
            col--;
        }
        c = col+1;
        while(c>=0 && c<gameBoard.getSize()){
            if(isKingGettingCheck(row,c,gameBoard,pieceColor,"rook")){
                return true;
            }
            col++;
        }
        //vertical check
        int r = row-1;
        while( r >=0 && r<gameBoard.getSize()){
            if(isKingGettingCheck(r,col,gameBoard,pieceColor,"rook")){
                return true;
            }
            row--;
        }
        r = row+1;
        while(r<gameBoard.getSize() && r >=0){
            if(isKingGettingCheck(r,col,gameBoard,pieceColor,"rook")){
                return true;
            }
            row++;
        }
        return false;
    }
    public boolean knightCheck(int row,int col,Board gameBoard,boolean pieceColor){
        int[] delrow = {-2,-1,-2,-1,1,2,2,1};
        int[] delcol = {-1,-2,1,2,2,1,-1,-2};
        for(int i=0;i<8;i++){
            int newRow = row+delrow[i];
            int newCol = col+delcol[i];
            if(isKingGettingCheck(newRow,newCol,gameBoard,pieceColor,"knight")){
                return true;
            }
        }
        return false;
    }
    public boolean pawnCheck(int row,int col,Board gameBoard,boolean pieceColor){
        int[] delrowForBlackPawn = {-1,-1};
        int[] delcolForBlackPawn = {-1,1};
        int[] delrowForWhitePawn = {1,1};
        int[] delcolForWhitePawn = {1,-1};
        for(int i=0;i<2;i++){
            int newRow = pieceColor?row+delrowForBlackPawn[i]:row+delrowForWhitePawn[i];
            int newCol = pieceColor?col+delcolForBlackPawn[i]:col+delcolForWhitePawn[i];
            if(isKingGettingCheck(newRow,newCol,gameBoard,pieceColor,"pawn")){
                return true;
            }
        }
        return false;
    }

    public boolean kingCheck(int row,int col,Board gameBoard,boolean pieceColor){
        int[] delrow = {-1,-1,-1,0,0,1,1,1};
        int[] delcol = {-1,0,1,-1,1,-1,0,1};
        for(int i=0;i<8;i++){
            int newRow = row+delrow[i];
            int newCol = col+delcol[i];
            if(isKingGettingCheck(newRow,newCol,gameBoard,pieceColor,"king")){
                return true;
            }
        }
        return false;
    }
    public boolean checkKingIndirectCheck(int pieceCurrRow,int pieceCurrCol,int pieceDestRow,int pieceDestCol,Board gameBoard,boolean pieceColor){
        gameBoard.movePieces(pieceCurrRow,pieceCurrCol,pieceCurrRow,pieceDestCol);
        List<Integer>kingsPos = KingsPosition.get(pieceColor);
        boolean res = checkKingGettingCheck(kingsPos.get(0),kingsPos.get(1),gameBoard,pieceColor);
        gameBoard.movePieces(pieceDestRow,pieceDestCol,pieceCurrRow,pieceCurrCol);
        return !res;
    }
    public boolean checkCheckMate(Board gameBoard,boolean pieceColor){
        List<Integer>kingsPos = KingsPosition.get(pieceColor);
        int currRow = kingsPos.get(0);
        int currCol = kingsPos.get(1);
        int[] delrow = {-1,-1,-1,0,0,1,1,1};
        int[] delcol = {-1,0,1,-1,1,-1,0,1};
        for(int i=0;i<8;i++){
            int newRow = currRow+delrow[i];
            int newCol = currCol+delcol[i];
            if(validateKingMove(gameBoard,currRow,currCol,newRow,newCol,pieceColor)){
                return false;
            }
        }
        return true;
    }
}
