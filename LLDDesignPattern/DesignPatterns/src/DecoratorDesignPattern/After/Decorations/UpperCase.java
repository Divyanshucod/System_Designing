package DecoratorDesignPattern.After.Decorations;

import DecoratorDesignPattern.After.Formatter;
import DecoratorDesignPattern.After.TextBase;

public class UpperCase extends Formatter {
    TextBase obj;
    public UpperCase(TextBase obj){
        this.obj = obj;
    }
    @Override
    public String format() {
        return obj.format().toUpperCase();
    }
}
