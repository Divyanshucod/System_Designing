package ChainOfResponsibilityPattern.After;

public class Ticket {
    String type;
    String status;
    public Ticket(String type,String status){
        this.type = type;
        this.status = "Pending";
    }
    public String getType(){
        return this.type;
    }
}
