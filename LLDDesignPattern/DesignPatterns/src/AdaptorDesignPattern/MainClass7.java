package AdaptorDesignPattern;

import AdaptorDesignPattern.Adaptor.CardAdaptor;
import AdaptorDesignPattern.Adaptor.CashOnDeliveryAdaptor;
import AdaptorDesignPattern.Adaptor.PaymentAdaptors;
import AdaptorDesignPattern.Adaptor.UPIAdaptor;

public class MainClass7 {
    public static void main(String[] args){
        //Shopping Cart Payment system.
        ProductIn product = new Product(5000,"realme-buds");
        PaymentAdaptors Upi = new UPIAdaptor(product);
        PaymentAdaptors card = new CardAdaptor(product);
        PaymentAdaptors COD = new CashOnDeliveryAdaptor(product);
        Upi.checkOut();
        card.checkOut();
        COD.checkOut();
    }
}
