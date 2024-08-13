package DecoratorDesignPattern.Before;

public class LowerCaseFormat {
    String text;
    public LowerCaseFormat(String text){
        this.text = text;
    }
    public String format(){
        return this.text.toLowerCase();
    }
}
