import entitiesAndMappings.Flight;
import entitiesAndMappings.FlightMapping;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import utils.EntityManager;


public class FlightMappingTest {

    private final EntityManager entityManager = new EntityManager();

    @Test
    public void checkIfFlightFunctionResultIsEmpty() {
        entityManager.setConnection();
        entityManager.setFlightMapping(new FlightMapping(new Flight("", "")));

        Assertions.assertTrue(entityManager.flightMapping.checkFlight(entityManager.getConnection()).isEmpty());
    }

    @Test
    public void checkIfFlightFunctionResultIsNotEmpty() {
        entityManager.setConnection();
        entityManager.setFlightMapping(new FlightMapping(new Flight("Cracow", "London")));

        Assertions.assertFalse(entityManager.flightMapping.checkFlight(entityManager.getConnection()).isEmpty());
    }
}
