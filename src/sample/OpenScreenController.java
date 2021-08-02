
package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

public class OpenScreenController implements Initializable {

    @FXML
    private Button logInButton;
    @FXML
    private Button signInButton;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    @FXML
    public void logInButtonOnAction(ActionEvent event) throws IOException {

            try {
                Parent loginParent = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("login.fxml")));
                Scene loginScene = new Scene(loginParent);

                Stage window = (Stage) ((Node)(event.getSource())).getScene().getWindow();
                window.setScene(loginScene);
                window.setTitle("MOOWER");
                window.centerOnScreen();
                window.show();

            } catch (Exception e) {
                e.printStackTrace();
                e.getCause();
            }
    }

    @FXML
    public void signInButtonOnAction(ActionEvent event) {

        try {
            Parent signinParent = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("signin.fxml")));
            Scene signinScene = new Scene(signinParent);

            Stage window = (Stage) ((Node) (event.getSource())).getScene().getWindow();
            window.setScene(signinScene);
            window.setTitle("MOOWER");
            window.centerOnScreen();
            window.show();

        } catch (Exception e) {
            e.printStackTrace();
            e.getCause();
        }
    }
}