package AdaptorDesignPattern.Adaptor;

import AdaptorDesignPattern.ProductIn;

public class CashOnDeliveryAdaptor implements PaymentAdaptors{
    ProductIn product;
    public CashOnDeliveryAdaptor(ProductIn product){
        this.product = product;
    }
    @Override
    public void checkOut() {
        System.out.println("For Cash on delivery 50Rs delivery charge");
        double remainPayment = (product.getPrice() + 50);
        System.out.println("Original Price:"+product.getPrice()+" WithExtraCharges:"+remainPayment);
    }
}
