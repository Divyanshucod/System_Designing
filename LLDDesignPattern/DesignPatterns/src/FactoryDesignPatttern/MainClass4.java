package FactoryDesignPatttern;

import FactoryDesignPatttern.After.*;
import FactoryDesignPatttern.Before.DataBaseConnect;
import FactoryDesignPatttern.Before.MongoDBConnect;
import FactoryDesignPatttern.Before.MySqlConnect;
import FactoryDesignPatttern.Before.OracleConnect;

public class MainClass4 {
    public static void main(String[] args){
      //Before
        DataBaseConnect connect = null;
        String DataBaseType = "mysql";//you can change this dynamically and add line to take input.

        if (DataBaseType.equals("mysql")){
           connect = new MySqlConnect();
        }
        else if (DataBaseType.equals("oracle")){
            connect = new OracleConnect();
        }
        else if (DataBaseType.equals("mongodb")){
            connect = new MongoDBConnect();
        }
        else{
            System.out.println("Invalid connection!");
        }
        connect.connect();
    }
     //After
       /* DataBaseConnectionFactory factory = null;
        String DataBaseType = "mysql";//you can change this dynamically and add line to take input.

        if (DataBaseType.equals("mysql")){
            factory = new MySqlConnectionFactory();
        }
        else if (DataBaseType.equals("oracle")){
            factory = new OracleConnectionFactory();
        }
        else if (DataBaseType.equals("mongodb")){
            factory = new MongoDBConnectionFactory();
        }
        else{
            System.out.println("Invalid connection!");
        }
        DataBaseConnection connection = factory.createConnection();
        connection.connect();
    }*/

    // To Check What is actually going on and how they are different and so know check the explainationOfPattern file
}
