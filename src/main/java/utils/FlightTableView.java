package utils;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;


public class FlightTableView {

    StringProperty from  = new SimpleStringProperty();
    StringProperty to = new SimpleStringProperty();
    StringProperty date = new SimpleStringProperty();
    IntegerProperty cost = new SimpleIntegerProperty();

    public String getFrom() {
        return from.get();
    }

    public StringProperty fromProperty() {
        return from;
    }

    public void setFrom(String from) {
        this.from.set(from);
    }

    public String getTo() {
        return to.get();
    }

    public StringProperty toProperty() {
        return to;
    }

    public void setTo(String to) {
        this.to.set(to);
    }

    public String getDate() {
        return date.get();
    }

    public StringProperty dateProperty() {
        return date;
    }

    public void setDate(String date) {
        this.date.set(date);
    }

    public int getCost() {
        return cost.get();
    }

    public IntegerProperty costProperty() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost.set(cost);
    }

}
