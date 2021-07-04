package sample;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;

import java.io.File;
import java.net.URL;
import java.util.EventListener;
import java.util.ResourceBundle;

public class SignInController implements Initializable {

    @FXML
    private TextField firstNameField;
    @FXML
    private TextField lastNameField;
    @FXML
    private TextField usernameField;
    @FXML
    private PasswordField passwordField;
    @FXML
    private PasswordField confirmPasswordField;
    @FXML
    private Button registerButton;
    @FXML
    private Button cancelButton;
    @FXML
    private ImageView brandingImageView;
    @FXML
    private Label registrationMessageLabel;
    @FXML
    private Label passwordConfirmationFailMessageLabel;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        File brandingFile = new File("img/moowericon.png");
        Image brandingImage = new Image(brandingFile.toURI().toString());
        brandingImageView.setImage(brandingImage);

        confirmPasswordField.textProperty().addListener(new ChangeListener<String>() {

            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {

                passMatch();

            }
        });

    }

    public void cancelButtonOnAction(ActionEvent event) {
        Stage signinStage = (Stage) cancelButton.getScene().getWindow();
        signinStage.close();
    }

    public void registerButtonOnAction(ActionEvent event) {
        //if passwordValidation() returns true, set registrationMessageLabel text,
        //if false then set passwordConfirmationFailMessageLabel message
    }

    public void passMatch() {
        if (!passwordField.getText().equals(confirmPasswordField.getText())) {
            passwordConfirmationFailMessageLabel.setText("Passwords do not match!");
        } else if (passwordField.getText().equals(confirmPasswordField.getText()) && !passwordField.getText().isBlank()) {
            passwordConfirmationFailMessageLabel.setText("Matching");
        } else {
            passwordConfirmationFailMessageLabel.setText("");
        }
    }

    public void passwordValidation() {

//        if (firstNameField.getText().isBlank() || lastNameField.getText().isBlank() || usernameField.getText().isBlank() || passwordField.getText().isBlank() || confirmPasswordField.getText().isBlank()) {
//            passwordConfirmationFailMessageLabel.setText("All fields are required!");
//        }
    }
}
