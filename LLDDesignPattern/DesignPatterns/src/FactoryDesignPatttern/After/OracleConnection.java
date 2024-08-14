package FactoryDesignPatttern.After;

public class OracleConnection implements DataBaseConnection{
    @Override
    public void connect() {
        System.out.println("connected to Oracle database!");
    }
}
