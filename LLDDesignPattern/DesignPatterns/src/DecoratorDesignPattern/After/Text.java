package DecoratorDesignPattern.After;

public class Text extends TextBase{
    String text;
    public Text(String text){
        this.text = text;
    }
    @Override
    public String format() {
        return this.text;
    }
}
