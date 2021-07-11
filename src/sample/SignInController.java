package sample;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.stage.Stage;

import java.io.File;
import java.net.URL;
import java.sql.Connection;
import java.sql.Statement;
import java.util.EventListener;
import java.util.Objects;
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

                passwordsMatching();

            }
        });

    }

    public void cancelButtonOnAction(ActionEvent event) {
        Stage signinStage = (Stage) cancelButton.getScene().getWindow();
        signinStage.close();
    }

    public void registerButtonOnAction(ActionEvent event) {

        registerNewUser();

    }

    private String getPasswordFieldText() {
        return passwordField.getText();
    }

    private String getConfirmPasswordFieldText() {
        return confirmPasswordField.getText();
    }

    public boolean passwordsMatching() {

        if (!getPasswordFieldText().equals(getConfirmPasswordFieldText())) {
            passwordConfirmationFailMessageLabel.setText("Passwords do not match!");
            passwordConfirmationFailMessageLabel.setTextFill(Color.RED);
            return false;
        } else if (getPasswordFieldText().equals(getConfirmPasswordFieldText()) && !getPasswordFieldText().isBlank()) {
            passwordConfirmationFailMessageLabel.setTextFill(Color.GREEN);
            passwordConfirmationFailMessageLabel.setText("Matching");
            return true;
        } else {
            passwordConfirmationFailMessageLabel.setText("");
            return false;
        }

    }

    public void registerNewUser() {
        DatabaseConnection connecting = new DatabaseConnection();
        Connection connectBD = connecting.getConnection();

        String firstname = firstNameField.getText();
        String lastname = lastNameField.getText();
        String username = usernameField.getText();
        String password = passwordField.getText();

        String insertFields = "INSERT INTO user_account(lastname, firstname, username, password) VALUES ('";
        String insertValues = firstname + "','" + lastname + "','" + username + "','" + password + "')";
        String insertToRegister = insertFields + insertValues;


        if (passwordsMatching() && fillChecker()) {
            try {

                Statement statement = connectBD.createStatement();
                statement.executeUpdate(insertToRegister);

                registrationMessageLabel.setText("Registered successfully!");

                openLogIn();

            } catch (Exception exception){

                exception.getCause();
                exception.printStackTrace();

            }
        } else {
            passwordConfirmationFailMessageLabel.setText("All fields are required!");
        }

    }

    public boolean fillChecker() {

        return !firstNameField.getText().isBlank() && !lastNameField.getText().isBlank() && !usernameField.getText().isBlank() && !passwordField.getText().isBlank() && !confirmPasswordField.getText().isBlank();
    }

    public void openLogIn() {

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
}
