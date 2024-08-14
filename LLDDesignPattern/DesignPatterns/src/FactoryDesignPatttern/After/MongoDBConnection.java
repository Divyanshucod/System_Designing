package FactoryDesignPatttern.After;

public class MongoDBConnection implements DataBaseConnection{
    @Override
    public void connect() {
        System.out.println("Connected to mongoDB database!");
    }
}
