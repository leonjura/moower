
package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
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
                Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("login.fxml")));
                Stage loginStage = new Stage();
                loginStage.setTitle("MOOWER");
                loginStage.setScene(new Scene(root, 520, 400));
                loginStage.show();
                // Hide current window
                // ((Node)(event.getSource())).getScene().getWindow().hide();
            } catch (Exception e) {
                e.printStackTrace();
                e.getCause();
            }
    }

    public void signInButtonOnAction(ActionEvent event) {

        try {

            Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("signin.fxml")));
            Stage signInStage = new Stage();
            signInStage.setTitle("MOOWER");
            signInStage.setScene(new Scene(root, 520, 400));
            signInStage.show();
            // Hide current window
            // ((Node)(event.getSource())).getScene().getWindow().hide();

        } catch (Exception e) {
            e.printStackTrace();
            e.getCause();
        }

    }
}