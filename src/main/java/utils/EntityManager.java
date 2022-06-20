package utils;

import entitiesAndMappings.FlightMapping;
import entitiesAndMappings.UserMapping;

import java.sql.*;

public class EntityManager {

    private Connection connection;

    public UserMapping userMapping;
    public FlightMapping flightMapping;

    public EntityManager()  {}

    public void setConnection() {
        try{
            this.connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/flightmanageapp", "root", "Hubert2001.");
        }
        catch (Exception e) {

            e.printStackTrace();
        }
    }

    public void closeConnection() {
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void setUserMapping(UserMapping userMapping) {
        this.userMapping = userMapping;
    }

    public void setFlightMapping(FlightMapping flightMapping) {
        this.flightMapping = flightMapping;
    }

    public Connection getConnection() { return connection;}
}
