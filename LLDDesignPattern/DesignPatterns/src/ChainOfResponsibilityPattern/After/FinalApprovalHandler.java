package ChainOfResponsibilityPattern.After;

public class FinalApprovalHandler implements Handlers{
    Handlers nexthandler;
    public FinalApprovalHandler(Handlers nexthandler){
        this.nexthandler = nexthandler;
    }
    @Override
    public String handle(Ticket ticket) {
        if(ticket.getType().equals("Final")){
            return "Application approved get certificate from college!";
        }else {
            return "certificate approved";
        }
    }

}
