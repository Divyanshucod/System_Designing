package CompositeDesignPattern;

import CompositeDesignPattern.After.*;

public class MainClass6 {
    public static void main(String[] args){
        ComponyWorkers employee1 = new Employee("Rahul");
        ComponyWorkers employee2 = new Employee("Rajesh");
        ComponyWorkers employee3 = new Employee("Rahul");
        ComponyWorkers employee4 = new Employee("Rajesh");
        ComponyWorkers marketingTeam1= new MarketingTeam("Team A");
        marketingTeam1.addWorkers(employee1);
        marketingTeam1.addWorkers(employee2);
        ComponyWorkers marketingTeam2= new MarketingTeam("Team B");
        marketingTeam2.addWorkers(employee3);
        marketingTeam2.addWorkers(employee4);
        ComponyWorkers manager1 = new Manager("MD Anshu");
        manager1.addWorkers(marketingTeam1);
        ComponyWorkers manager2 = new Manager("Nikhil Mukharji");
        manager2.addWorkers(marketingTeam2);
        ComponyWorkers ceo = new CEO("DK Singh");
        ceo.addWorkers(manager1);
        ceo.addWorkers(manager2);

        System.out.println("Full Details:");
        ceo.displayDetails();
    }
}
