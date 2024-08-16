package ChainOfResponsibilityPattern.After;

public class TechnicalSupportTeam implements Handlers{
    Handlers nexthandler;
    public TechnicalSupportTeam(Handlers nexthandler){
        this.nexthandler = nexthandler;
    }
    @Override
    public String handle(Ticket ticket) {
        if(ticket.getType().equals("Technical")){
            return "Request is processed by Technical Team";
        }else {
            System.out.println("Sending to Approval Team");
            return this.nexthandler.handle(ticket);
        }
    }
}

