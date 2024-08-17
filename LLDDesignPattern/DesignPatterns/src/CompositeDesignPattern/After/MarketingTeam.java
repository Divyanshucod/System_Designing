package CompositeDesignPattern.After;

import java.util.ArrayList;
import java.util.List;

public class MarketingTeam implements ComponyWorkers{
    List<ComponyWorkers>employees;
    String teamName;
    public MarketingTeam(String name){
        this.teamName = name;
        this.employees = new ArrayList<>();
    }
    @Override
    public void displayDetails() {
        System.out.println("Team Name:"+this.teamName);
        System.out.println("Employees of team:");
        for (ComponyWorkers employee:employees){
            employee.displayDetails();
        }
    }

    @Override
    public void addWorkers(ComponyWorkers employee) {
         this.employees.add(employee);
    }
}
