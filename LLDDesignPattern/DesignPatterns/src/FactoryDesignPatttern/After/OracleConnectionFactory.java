package FactoryDesignPatttern.After;

public class OracleConnectionFactory implements DataBaseConnectionFactory{
    @Override
    public DataBaseConnection createConnection() {
        return new OracleConnection();
    }
}
