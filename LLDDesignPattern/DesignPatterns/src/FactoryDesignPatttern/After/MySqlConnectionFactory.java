package FactoryDesignPatttern.After;

public class MySqlConnectionFactory implements DataBaseConnectionFactory{

    @Override
    public DataBaseConnection createConnection() {
        return new MySqlConnection();
    }
}
