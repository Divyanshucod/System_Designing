package ExpenseP;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Expense implements ExpenseIn{
    String title;
    double amount;
    int id;
    String TypeOfDistribution;
    List<Member>members;
    public Expense(String title, double amount,List<Member>members,String type){
        //u can change this to get all members at first and  store it you add one by one
        int id = (int) Math.floor(Math.random()*100);
        this.id = id;
        this.title = title;
        this.amount = amount;
        this.members = members;
        this.TypeOfDistribution = type;
        notifyObservers();
    }
    @Override
    public double getAmount() {
        return this.amount;
    }

    @Override
    public String getTitle() {
        return this.title;
    }

    @Override
    public List<Member> getMembers() {
        return members;
    }

    @Override
    public int getId() {
        return this.id = id;
    }
    public void setMembers(String name,String email){
        //check already exist
        for (Member member:members){
            if(member.getEmail() == email){
                System.out.println("Member is alreday added");
            }
        }
        members.add(new Member(name,email));
    }
    public void EqualDistribution(){
        double value = Math.floor(this.amount/members.size());
        for (Member member:members){
            member.setAmount(value);
        }
    }
    public void PercentageDistribution(List<String>emails, List<Double>percentages){
        if(emails.size() != percentages.size()){
            System.out.println("Invalid Distribution Make Sure Size Should be same of email and percentages");
        }
        HashMap<String,Member>EmailToMembers = new HashMap<>();
        for(Member member:members){
            EmailToMembers.put(member.getEmail(),member);
        }
        for (int i =0;i<emails.size();i++){
           Member member =  EmailToMembers.get(emails.get(i));
           double percentage = percentages.get(i);
           //calculate price on the basis of percentage
            double nomirator = amount*percentage;
            double price = nomirator/100;
            member.setAmount(price);
        }
    }
    public void notifyObservers(){
        for (Member member:members){
            member.update("New Expense Added , Id -> "+id+" title-> "+title);
        }
    }
}
