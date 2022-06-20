import utils.FlightTableView;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;

import javafx.scene.control.TableView;

import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.testfx.framework.junit5.ApplicationTest;

import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;


public class MainScreenTest extends ApplicationTest{

    final int SCENE_WIDTH = 600;
    final int SCENE_HEIGHT = 400;
    Scene scene;
    FXMLLoader fxmlLoader;

    /**
     * Will be called with {@code @Before} semantics, i.e. before each test method.
     */
    @Override
    public void start(Stage stage) throws IOException {

        fxmlLoader = new FXMLLoader(getClass().getResource("main_screen.fxml"));

        scene = new Scene(fxmlLoader.load(), SCENE_WIDTH, SCENE_HEIGHT);

        stage.setScene(scene);
        stage.show();
    }

    @Test
    public void CheckIfFlightsAnchorPaneIsNotVisible() {
        // when:
        AnchorPane flightsAnchorPane = (AnchorPane) scene.lookup("#flightsAnchorPane");

        // then:
        Assertions.assertFalse(flightsAnchorPane.isVisible());
    }

    @Test
    public void CheckIfFlightsAnchorPaneChangesToVisible() {
        // when:
        clickOn("#searchButton");
        AnchorPane flightsAnchorPane = (AnchorPane) scene.lookup("#flightsAnchorPane");

        // then:
        Assertions.assertTrue(flightsAnchorPane.isVisible());
    }

    @Test
    public void CheckIfTableViewIsEmpty() {
        // when:
        clickOn("#searchButton");
        TableView<FlightTableView> flights = (TableView<FlightTableView>) scene.lookup("#flightsTableView");

        // then:
        Assertions.assertTrue(flights.getItems().isEmpty());
    }

    @Test
    public void CheckIfTableViewChanges() {
        // when:

        TextField fromTextField = (TextField) scene.lookup("#fromTextField");
        TextField toTextField = (TextField) scene.lookup("#toTextField");

        fromTextField.setText("Warsaw");
        toTextField.setText("Madrid");


        clickOn("#searchButton");
        TableView<FlightTableView> flights = (TableView<FlightTableView>) scene.lookup("#flightsTableView");

        ObservableList<FlightTableView> flightsOL = flights.getItems();

        // then:
        Assertions.assertFalse(flights.getItems().isEmpty());
    }
}
