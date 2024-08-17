package CompositeDesignPattern.After;

import java.util.ArrayList;
import java.util.List;

public class Manager implements ComponyWorkers{
    String managerName;
    ComponyWorkers marketingTeamMembers;
    public Manager(String name){
        this.managerName = name;
        this.marketingTeamMembers = null;
    }
    @Override
    public void displayDetails() {
        System.out.println("Manager Name:"+this.managerName);
        System.out.println("Marketing Team Details:");
        marketingTeamMembers.displayDetails();
    }

    @Override
    public void addWorkers(ComponyWorkers workers) {
        this.marketingTeamMembers = workers;
    }
}
