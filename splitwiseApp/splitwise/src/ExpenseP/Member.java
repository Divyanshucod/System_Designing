package ExpenseP;

public class Member {
    String name;
    String email;
    double amount;
    public Member(String name,String email,double amount){
        this.amount = amount;
        this.name  = name;
        this.email = email;
    }
    public Member(String name,String email){
        this(name,email,0);
    }

    public String getName(){
        return name;
    };
    public String getEmail(){
        return email;
    };
    public void setAmount(double amount){
        this.amount = amount;
    };
    public double getAmount(){
        return amount;
    };
    public void update(String message){
        System.out.println("Observer Members Notification!");
        System.out.println("Hi! "+this.name+" "+message);
    }
}
