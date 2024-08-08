package SIngleResposibilityPrinciple.Before;

import javax.swing.plaf.IconUIResource;
import java.util.List;

/*
* here you can see we are creating all operations like Generating invoice,Printing Invoice in same class that why it violtes
* the SRP because here we have to reason to change class.
* in the future you will have multiple ways to print the invoice, via multiple device that time this class will become complex
* and unmanageable at a big scale.
* */
public class Invoice{
    String customerName;
    double amount;
    public Invoice(String name,double amount){
      this.customerName = name;
      this.amount = amount;
    }
    public String getCustomerName(){
        return this.customerName;
    }
    public double getAmount(){
        return this.amount;
    }
    public String GenerateInvoice(){
        return "Invoice Geneated For Customer: "+this.customerName+"Amount: "+this.amount;
    }

    public void printInvoice() {
        System.out.println(GenerateInvoice());
    }
}
