package AdaptorDesignPattern.Adaptor;

import AdaptorDesignPattern.ProductIn;

public class CardAdaptor implements PaymentAdaptors{
    ProductIn product;
    public CardAdaptor(ProductIn product){
        this.product = product;
    }
    @Override
    public void checkOut() {
        System.out.println("For Card 3000 off");
        double remainPayment = (product.getPrice() - 3000);
        System.out.println("Original Price:"+product.getPrice()+" AfterDiscount:"+remainPayment);
    }
}
