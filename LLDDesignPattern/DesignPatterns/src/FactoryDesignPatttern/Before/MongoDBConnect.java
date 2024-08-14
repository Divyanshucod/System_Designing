package FactoryDesignPatttern.Before;

import FactoryDesignPatttern.After.DataBaseConnection;

public class MongoDBConnect implements DataBaseConnect {
    @Override
    public void connect() {
        System.out.println("Connected to mongoDB database!");
    }
}
