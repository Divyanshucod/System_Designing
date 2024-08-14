package FactoryDesignPatttern.Before;

import FactoryDesignPatttern.After.DataBaseConnection;

public class MySqlConnect implements DataBaseConnect {
    @Override
    public void connect() {
        System.out.println("Connected to mysql database!");
    }
}
