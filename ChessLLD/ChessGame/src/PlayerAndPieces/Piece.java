package PlayerAndPieces;

public class Piece {
    PieceType troop;
    public Piece(PieceType troop){
        this.troop = troop;
    }
    public PieceType getTroop(){
        return troop;
    }
}