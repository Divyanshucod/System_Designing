package CompositeDesignPattern.After;

import java.util.ArrayList;
import java.util.List;

public class CEO implements ComponyWorkers{
    List<ComponyWorkers>listOfManagers;
    String nameOfCeo;
    public CEO(String name){
        this.nameOfCeo = name;
        this.listOfManagers = new ArrayList<>();
    }
    @Override
    public void displayDetails() {
        System.out.println("Company's CEO:" + this.nameOfCeo);
        System.out.println("Managers And Their Details:");
        for(ComponyWorkers workers:listOfManagers){
            workers.displayDetails();
        }
    }
    @Override
    public void addWorkers(ComponyWorkers manager) {
        listOfManagers.add(manager);
    }
}
