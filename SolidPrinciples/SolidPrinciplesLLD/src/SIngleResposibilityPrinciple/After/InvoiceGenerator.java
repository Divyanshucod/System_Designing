package SIngleResposibilityPrinciple.After;

public class InvoiceGenerator {

    public String generateInvoice(InvoiceSys invoice){
        return "Invoice Geneated For Customer: "+invoice.customerName+"Amount: "+invoice.amount;
    }

    // more ways to generate invoice
}
