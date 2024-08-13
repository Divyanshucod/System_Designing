package DecoratorDesignPattern.Before;

public class UpperCaseFormat {
    String text;
    public UpperCaseFormat(String text){
        this.text = text;
    }
    public String format(){
        return this.text.toUpperCase();
    }
}
