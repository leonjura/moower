package sample;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.File;
import java.net.URL;
import java.sql.Connection;
import java.sql.Statement;
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
    private Button backButton;
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

    public void backButtonOnAction(ActionEvent event) {

        try {
            Parent signinParent = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("openscreen.fxml")));
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

    public void registerButtonOnAction(ActionEvent event) {

        registerNewUser(event);

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

    public void registerNewUser(ActionEvent event) {
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

                openLogIn(event);

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

    public void openLogIn(ActionEvent event) {

        try {
            Parent signinParent = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("login.fxml")));
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
