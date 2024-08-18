package AdaptorDesignPattern;

public class Product implements ProductIn{
    double price;
    String productName;
    public Product(double price,String name){
        this.productName = name;
        this.price = price;
    }
    @Override
    public double getPrice() {
        return this.price;
    }

    @Override
    public String getProductName() {
        return this.productName;
    }
}
