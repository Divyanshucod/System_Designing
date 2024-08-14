package FactoryDesignPatttern.After;

public class MySqlConnection implements DataBaseConnection{
    @Override
    public void connect() {
        System.out.println("Connected to mysql database!");
    }
}
