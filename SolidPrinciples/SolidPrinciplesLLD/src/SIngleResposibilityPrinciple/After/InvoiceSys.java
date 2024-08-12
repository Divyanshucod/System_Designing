package SIngleResposibilityPrinciple.After;

public class InvoiceSys {
    /*
     * here we have seperated the classes according to there corresponding responsibilities .
     *
     * */
        String customerName;
        double amount;
        public InvoiceSys(String name,double amount){
            this.customerName = name;
            this.amount = amount;
        }
        public String getCustomerName(){
            return this.customerName;
        }
        public double getAmount(){
            return this.amount;
        }
    }


