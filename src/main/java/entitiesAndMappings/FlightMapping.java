package entitiesAndMappings;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import utils.FlightTableView;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


public class FlightMapping {

    private final Flight flight;

    public FlightMapping(Flight flight) {
        this.flight = flight;
    }

    public ObservableList<FlightTableView> checkFlight(Connection connection) {

        ObservableList<FlightTableView> flightTableViews = FXCollections.observableArrayList();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(flight.findFlights);
            preparedStatement.setString(1, flight.getSource());
            preparedStatement.setString(2, flight.getDestination());

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {

                FlightTableView flightTableView = new FlightTableView();
                flightTableView.setFrom(resultSet.getString("source"));
                flightTableView.setTo(resultSet.getString("destination"));
                flightTableView.setDate(String.valueOf(resultSet.getDate("date")));
                flightTableView.setCost(resultSet.getInt("cost"));

                flightTableViews.add(flightTableView);
            }
            return flightTableViews;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
