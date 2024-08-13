package DecoratorDesignPattern;

import DecoratorDesignPattern.After.Decorations.Italic;
import DecoratorDesignPattern.After.Decorations.LowersCase;
import DecoratorDesignPattern.After.Decorations.UpperCase;

import DecoratorDesignPattern.After.Text;
import DecoratorDesignPattern.After.TextBase;
import DecoratorDesignPattern.Before.ItalicFormat;
import DecoratorDesignPattern.Before.LowerCaseFormat;
import DecoratorDesignPattern.Before.UpperCaseFormat;

public class MainClass3 {
    public static void main(String[] args){
        //Before(WithOut the design pattern)
        Text text = new Text("hi i am GOOd!");
        //lowercase
        LowerCaseFormat text1 = new LowerCaseFormat(text.format());
        System.out.println(text1.format());
        //lower + italic
        ItalicFormat text2 = new ItalicFormat(text1.format());
        System.out.println(text2.format());
        //lower + italic + upper
        UpperCaseFormat text3 = new UpperCaseFormat(text2.format());
        System.out.println(text3.format());
        //------- see explanation ---------//

        //After(With design pattern)
        TextBase textObj = new Text("hi I am GOOD!");
        System.out.println(textObj.format());
        TextBase formatToUpperCasePlusItalic = new Italic(new UpperCase(textObj));
        TextBase formatToUpperCasePlusItalicPlusLowercase = new LowersCase(formatToUpperCasePlusItalic);
        System.out.println(formatToUpperCasePlusItalic.format());
        System.out.println(formatToUpperCasePlusItalicPlusLowercase.format());
    }
}
