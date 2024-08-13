package DecoratorDesignPattern.After.Decorations;

import DecoratorDesignPattern.After.Formatter;
import DecoratorDesignPattern.After.TextBase;

public class Italic extends Formatter {
    TextBase obj;
    public Italic(TextBase obj){
        this.obj = obj;
    }
    @Override
    public String format() {
        return "<i> "+obj.format()+" </i>";
    }
}
