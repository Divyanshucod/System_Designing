package FactoryDesignPatttern.After;

public class MongoDBConnectionFactory implements DataBaseConnectionFactory{
    @Override
    public DataBaseConnection createConnection() {
        return new MongoDBConnection();
    }
}
