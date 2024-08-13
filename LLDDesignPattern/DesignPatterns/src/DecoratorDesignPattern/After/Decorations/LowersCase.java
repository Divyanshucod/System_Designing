package DecoratorDesignPattern.After.Decorations;

import DecoratorDesignPattern.After.Formatter;
import DecoratorDesignPattern.After.TextBase;

public class LowersCase extends Formatter {
    TextBase obj;
    public LowersCase(TextBase obj){
        this.obj = obj;
    }
    @Override
    public String format() {
        return obj.format().toLowerCase();
    }
}
