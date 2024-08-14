package FactoryDesignPatttern.Before;

import FactoryDesignPatttern.After.DataBaseConnection;

public class OracleConnect implements DataBaseConnect {
    @Override
    public void connect() {
        System.out.println("connected to Oracle database!");
    }
}
