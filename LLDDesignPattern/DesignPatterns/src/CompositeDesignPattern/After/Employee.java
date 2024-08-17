package CompositeDesignPattern.After;

public class Employee implements ComponyWorkers{
    String nameOfEmployee;
    public Employee(String name){
        this.nameOfEmployee = name;
    }
    @Override
    public void displayDetails() {
        System.out.println("Employee Name:" + this.nameOfEmployee);
    }

    @Override
    public void addWorkers(ComponyWorkers workers) {
       // nothing will be add here because it is the last node in composite design.
    }
}
