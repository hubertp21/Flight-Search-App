package entitiesAndMappings;

public class Flight {

    private String source;
    private String destination;

    public String findFlights = "SELECT * FROM flights WHERE source = ? AND destination = ?";

    public Flight(String source, String destination) {
        this.source = source;
        this.destination = destination;

    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

}
