import javafx.fxml.FXMLLoader;

import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import org.junit.jupiter.api.Test;
import org.testfx.assertions.api.Assertions;
import org.testfx.framework.junit5.ApplicationTest;

import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;



public class LoginPanelTest extends ApplicationTest {

    final int SCENE_WIDTH = 520;
    final int SCENE_HEIGHT = 400;
    Scene scene;
    FXMLLoader fxmlLoader;

    /**
     * Will be called with {@code @Before} semantics, i.e. before each test method.
     */
    @Override
    public void start(Stage stage) throws IOException {

        fxmlLoader = new FXMLLoader(getClass().getResource("login_panel.fxml"));

        scene = new Scene(fxmlLoader.load(), SCENE_WIDTH, SCENE_HEIGHT);

        stage.setScene(scene);
        stage.show();
    }

    @Test
    public void CheckIfBlankTextChangesLoginMessageLabel() {
        // when:
        clickOn("#loginButton");

        final Label loginMessageLabel = (Label) scene.lookup("#loginMessageLabel");

        // then:
        Assertions.assertThat(loginMessageLabel).hasText("Enter username and password");
    }

    @Test
    public void CheckIfUsernameAndPasswordAreWrong() {
        // when:

        TextField usernameTextField = (TextField) scene.lookup("#enterUsernameTextField");
        TextField passwordTextField = (TextField) scene.lookup("#enterPasswordTextField");

        usernameTextField.setText("hubert");
        passwordTextField.setText("hubert");

        clickOn("#loginButton");
        final Label loginMessageLabel = (Label) scene.lookup("#loginMessageLabel");

        // then:
        Assertions.assertThat(loginMessageLabel).hasText("Wrong username or password");
    }

    @Test
    public void CheckIfUsernameAndPasswordAreGood() {
        // when:

        TextField usernameTextField = (TextField) scene.lookup("#enterUsernameTextField");
        TextField passwordTextField = (TextField) scene.lookup("#enterPasswordTextField");

        usernameTextField.setText("root");
        passwordTextField.setText("toor");

        clickOn("#loginButton");
        final Label loginMessageLabel = (Label) scene.lookup("#loginMessageLabel");

        // then:
        Assertions.assertThat(loginMessageLabel).hasText("Successfully logged!");
    }

    @Test
    public void CheckIfScenesChange() {
        // when:

        clickOn("#registerButton");

        // then:
        Assertions.assertThat(fxmlLoader.equals(new FXMLLoader(getClass().getResource("register_panel.fxml"))));
    }

}
