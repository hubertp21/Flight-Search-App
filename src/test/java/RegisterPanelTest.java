import javafx.fxml.FXMLLoader;

import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import org.junit.jupiter.api.Test;
import org.testfx.assertions.api.Assertions;
import org.testfx.framework.junit5.ApplicationTest;

import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;



public class RegisterPanelTest extends ApplicationTest {

    final int SCENE_WIDTH = 225;
    final int SCENE_HEIGHT = 535;
    Scene scene;
    FXMLLoader fxmlLoader;

    /**
     * Will be called with {@code @Before} semantics, i.e. before each test method.
     */
    @Override
    public void start(Stage stage) throws IOException {

        fxmlLoader = new FXMLLoader(getClass().getResource("register_panel.fxml"));

        scene = new Scene(fxmlLoader.load(), SCENE_WIDTH, SCENE_HEIGHT);

        stage.setScene(scene);
        stage.show();
    }

    @Test
    public void CheckIfBlankTextChangesRegisterMessageLabel() {
        // when:
        clickOn("#registerButton");

        final Label loginMessageLabel = (Label) scene.lookup("#registerMessageLabel");

        // then:
        Assertions.assertThat(loginMessageLabel).hasText("Enter username and password");
    }

    @Test
    public void CheckIfPasswordsDoNotMatch() {
        // when:

        TextField usernameTextField = (TextField) scene.lookup("#enterUsernameTextField");
        TextField passwordTextField = (TextField) scene.lookup("#enterPasswordTextField");
        TextField confirmPasswordTextField = (TextField) scene.lookup("#confirmPasswordTextField");

        usernameTextField.setText("hubert");
        passwordTextField.setText("hubert");
        confirmPasswordTextField.setText("trebuh");

        clickOn("#registerButton");
        final Label loginMessageLabel = (Label) scene.lookup("#registerMessageLabel");

        // then:
        Assertions.assertThat(loginMessageLabel).hasText("Passwords must match!");
    }

    @Test
    public void CheckIfRegistered() {
        // when:

        TextField usernameTextField = (TextField) scene.lookup("#enterUsernameTextField");
        TextField passwordTextField = (TextField) scene.lookup("#enterPasswordTextField");
        TextField confirmPasswordTextField = (TextField) scene.lookup("#confirmPasswordTextField");

        usernameTextField.setText("a");
        passwordTextField.setText("b");
        confirmPasswordTextField.setText("b");

        clickOn("#registerButton");
        final Label registerMessageLabel = (Label) scene.lookup("#registerMessageLabel");

        // then:
        Assertions.assertThat(registerMessageLabel).hasText("Successfully registered!");
    }

    @Test
    public void CheckIfScenesChange() {
        // when:

        clickOn("#backButton");

        // then:
        Assertions.assertThat(fxmlLoader.equals(new FXMLLoader(getClass().getResource("login_panel.fxml"))));
    }

}

