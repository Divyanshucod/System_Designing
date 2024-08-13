package DecoratorDesignPattern.Before;

public class Text {
    String text;
    public Text(String text){
        this.text = text;
    }
    public String format(){
        return this.text;
    }
}
