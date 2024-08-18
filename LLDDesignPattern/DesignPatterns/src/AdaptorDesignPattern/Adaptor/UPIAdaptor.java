package AdaptorDesignPattern.Adaptor;

import AdaptorDesignPattern.ProductIn;

public class UPIAdaptor implements PaymentAdaptors{
    ProductIn product;
    public UPIAdaptor(ProductIn product){
        this.product = product;
    }
    @Override
    public void checkOut() {
        System.out.println("For UPI 10% off");
        double remainPayment = (product.getPrice() - (product.getPrice() * 10)/100);
        System.out.println("Original Price:"+product.getPrice()+" AfterDiscount:"+remainPayment);
    }
}
