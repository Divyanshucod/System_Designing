package DecoratorDesignPattern.Before;



public class ItalicFormat {
    String text;
    public ItalicFormat(String text){
        this.text = text;
    }
    public String format(){
        return "<i> "+this.text+" </i>";
    }
}
