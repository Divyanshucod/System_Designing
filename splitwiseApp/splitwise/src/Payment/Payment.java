package Payment;

import ExpenseP.Expense;
import ExpenseP.Member;

import java.util.ArrayList;
import java.util.List;

public class Payment {
    int id,expense_id;
    String email;
    double amount;
    public boolean DoPayment(List<Expense>totalExpenses,int expense_id,String memberEmail,double amount){
        Expense expen = null;
        for(Expense expense : totalExpenses){
            if(expense_id == expense.getId()){
                expen = expense;
                break;
            }
        }
        if(expen == null){
            System.out.println("Invalid Expense_id");
            return false;
        }
        List<Member> members = expen != null ? expen.getMembers() : new ArrayList<>();
        if(members.size() == 0){
            System.out.println("No Member to Perform payment");
            return false;
        }
        boolean paymentHappen = false;
        for (Member member:members){
            if(member.getEmail().equals(memberEmail)){
                double totalamount = member.getAmount();
                double updatedAmount = totalamount - amount;
                member.setAmount(updatedAmount);
                paymentHappen = true;
                break;
            }
        }
        if(paymentHappen){
            this.id = (int)Math.floor(Math.random()*100);
            this.expense_id = expense_id;
            this.email = memberEmail;
            this.amount = amount;
            notifyObeservers(members);
            System.out.println("Payment done!");
        }
        return paymentHappen;
    }
    public void notifyObeservers(List<Member>members){
        for (Member member:members){
            member.update("Payment Done On ExpenseId->"+expense_id+" Rupess->"+amount+" email->"+email);
        }
    }
    public String getPayerEmail(){
        return this.email;
    }
    public double getPayedAmount(){
        return this.amount;
    }
    public int getPaymentId(){
        return this.id;
    }
    public int getPayedExpenseId(){
        return  this.expense_id;
    }
}
