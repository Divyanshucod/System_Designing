package PlayerAndPieces;

import java.util.ArrayList;
import java.util.List;

public class CreatePieces {
    Character type;
    List<Piece>listOfPieces;
    public CreatePieces(Character type){
        this.type = type;
        this.listOfPieces = new ArrayList<>();
    }
    public void createPieces(){
        //8 pawns
        for(int i=0;i<8;i++){
            Piece pawn = type.equals('B') ? new Piece(PieceType.BP) : new Piece(PieceType.WP);
            listOfPieces.add(pawn);
        }
        //2 Bishops
        for(int i=0;i<2;i++){
            Piece bishop = type.equals('B') ? new Piece(PieceType.BB) : new Piece(PieceType.WB);
            listOfPieces.add(bishop);
        }
        //2 Rooks
        for(int i=0;i<2;i++){
            Piece rook = type.equals('B') ? new Piece(PieceType.BR) : new Piece(PieceType.WR);
            listOfPieces.add(rook);
        }
        //2 Knights
        for(int i=0;i<2;i++){
            Piece knight = type.equals('B') ? new Piece(PieceType.Bk) : new Piece(PieceType.Wk);
            listOfPieces.add(knight);
        }
        //1 king
        Piece king = type.equals('B') ? new Piece(PieceType.BK) : new Piece(PieceType.WK);
        listOfPieces.add(king);
        //1 Queen
        Piece queen = type.equals('B') ? new Piece(PieceType.BQ) : new Piece(PieceType.WQ);
        listOfPieces.add(queen);

        System.out.println("Pieces created successfully!");
    }
}
