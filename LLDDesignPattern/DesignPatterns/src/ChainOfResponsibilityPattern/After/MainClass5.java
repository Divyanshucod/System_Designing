package ChainOfResponsibilityPattern.After;

public class MainClass5 {
    public static void main(String[] args){
        Handlers finalApproval = new FinalApprovalHandler(null);
        Handlers technicalApproval = new TechnicalSupportTeam(finalApproval);
        Handlers frontdestApproval = new FrontDestHandler(technicalApproval);
        Ticket ticket = new Ticket("Basic","Pending");
        System.out.println(frontdestApproval.handle(ticket));
    }
}

