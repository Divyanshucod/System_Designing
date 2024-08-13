package PlayerAndPieces;

public class Players implements PlayerIn{
    String name="Name is not given";
    String color = "Color is not given";
    CreatePieces obj = null;
    public Players(CreatePieces obj,String name,String color){
        this.obj = obj;
        this.name = name;
        this.color = color;
    }

    @Override
    public String getname() {
        return this.name;
    }

    @Override
    public void setname(String name) {
        this.name = name;

    }

    @Override
    public String getPieceColor() {
       return this.color;
    }

    @Override
    public void setPieceColor(String color) {
      this.color = color;
    }
    public boolean getPieceColorBoolean() {
        return !this.color.equals("black");
    }
}
