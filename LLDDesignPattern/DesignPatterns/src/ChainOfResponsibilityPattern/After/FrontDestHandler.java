package ChainOfResponsibilityPattern.After;

public class FrontDestHandler implements Handlers{
    Handlers nexthandler;
    public FrontDestHandler(Handlers nexthandler){
        this.nexthandler = nexthandler;
    }
    @Override
    public String handle(Ticket ticket) {
        if(ticket.getType().equals("Basic")){
            return "Request is processed by frontDesk";
        }else {
            System.out.println("Sending to Technical Team");
            return this.nexthandler.handle(ticket);
        }
    }
}
