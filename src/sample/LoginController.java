package sample;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javafx.event.ActionEvent;

import java.io.File;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Objects;
import java.util.ResourceBundle;

public class LoginController implements Initializable {

    @FXML
    private Label loginFailMessageField;
    @FXML
    private ImageView brandingImageView;
    @FXML
    private ImageView padlockImageView;
    @FXML
    private TextField usernameTextField;
    @FXML
    private PasswordField enterPasswordField;
    @FXML
    private CheckBox passwordToggle;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        File brandingFile = new File("img/moowericon.png");
        Image brandingImage = new Image(brandingFile.toURI().toString());
        brandingImageView.setImage(brandingImage);

        File padlockFile = new File("img/padlock.png");
        Image padlockImage = new Image(padlockFile.toURI().toString());
        padlockImageView.setImage(padlockImage);
    }

    public void logInButtonOnAction(ActionEvent event) {
        if (!usernameTextField.getText().isBlank() && !enterPasswordField.getText().isBlank()) {
            validateLogin(event);
        } else {
            loginFailMessageField.setText("Please enter valid username and password!");
        }
    }

    public void goToMenu(ActionEvent event) {
        try {
            Parent signinParent = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("menu.fxml")));
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

    public void showPassword(ActionEvent event) {
        CheckBox passwordToggle = new CheckBox("Show password");
        
    }

    public void validateLogin(ActionEvent event) {
        DatabaseConnection connectNow = new DatabaseConnection();
        Connection connectDB = connectNow.getConnection();

        String verifyLogin = "SELECT count(1) FROM user_account WHERE username = '" + usernameTextField.getText() + "' AND password = '" + enterPasswordField.getText() + "'";

        try {

            Statement statement = connectDB.createStatement();
            ResultSet queryResult = statement.executeQuery(verifyLogin);

            while (queryResult.next()) {
                if (queryResult.getInt(1) == 1) {
                    loginFailMessageField.setText("Log in successful!");
                    goToMenu(event);
                } else {
                    loginFailMessageField.setText("Invalid login. Please try again!");
                }
            }

        } catch (Exception e){
           e.printStackTrace();
           e.getCause();
        }
    }

}
