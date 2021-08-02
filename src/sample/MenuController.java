package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.File;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

public class MenuController implements Initializable {

    @FXML
    private ImageView logoutImageView;
    @FXML
    private ImageView casesImageView;
    @FXML
    private ImageView toolsImageView;
    @FXML
    private ImageView customersImageView;
    @FXML
    private ImageView servicesImageView;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        File logoutFile = new File("img/logout.png");
        Image logoutImage = new Image(logoutFile.toURI().toString());
        logoutImageView.setImage(logoutImage);

        File casesFile = new File("img/cases.png");
        Image casesImage = new Image(casesFile.toURI().toString());
        casesImageView.setImage(casesImage);

        File toolsFile = new File("img/lawn-mower.png");
        Image toolsImage = new Image(toolsFile.toURI().toString());
        toolsImageView.setImage(toolsImage);

        File customersFile = new File("img/customer.png");
        Image customersImage = new Image(customersFile.toURI().toString());
        customersImageView.setImage(customersImage);

        File servicesFile = new File("img/services.png");
        Image servicesImage = new Image(servicesFile.toURI().toString());
        servicesImageView.setImage(servicesImage);

    }

    public void casesButtonOnAction(ActionEvent event) {

        try {
            Parent casesParent = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("cases.fxml")));
            Scene casesScene = new Scene(casesParent);

            Stage window = (Stage) ((Node)(event.getSource())).getScene().getWindow();
            window.setScene(casesScene);
            window.setTitle("MOOWER");
            window.centerOnScreen();
            window.show();

        } catch (Exception e) {
            e.printStackTrace();
            e.getCause();
        }

    }

    public void toolsButtonOnAction(ActionEvent event) {

        try {
            Parent toolsParent = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("tools.fxml")));
            Scene toolsScene = new Scene(toolsParent);

            Stage window = (Stage) ((Node)(event.getSource())).getScene().getWindow();
            window.setScene(toolsScene);
            window.setTitle("MOOWER");
            window.centerOnScreen();
            window.show();

        } catch (Exception e) {
            e.printStackTrace();
            e.getCause();
        }

    }

    public void customersButtonOnAction(ActionEvent event) {

        try {
            Parent customersParent = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("customers.fxml")));
            Scene customersScene = new Scene(customersParent);

            Stage window = (Stage) ((Node)(event.getSource())).getScene().getWindow();
            window.setScene(customersScene);
            window.setTitle("MOOWER");
            window.centerOnScreen();
            window.show();

        } catch (Exception e) {
            e.printStackTrace();
            e.getCause();
        }

    }

    public void servicesButtonOnAction(ActionEvent event) {

        try {
            Parent servicesParent = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("services.fxml")));
            Scene servicesScene = new Scene(servicesParent);

            Stage window = (Stage) ((Node)(event.getSource())).getScene().getWindow();
            window.setScene(servicesScene);
            window.setTitle("MOOWER");
            window.centerOnScreen();
            window.show();

        } catch (Exception e) {
            e.printStackTrace();
            e.getCause();
        }

    }

    public void logOutButtonOnAction(ActionEvent event) {

        try {
            Parent openScreenParent = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("openscreen.fxml")));
            Scene openSceneScene = new Scene(openScreenParent);

            Stage window = (Stage) ((Node)(event.getSource())).getScene().getWindow();
            window.setScene(openSceneScene);
            window.setTitle("MOOWER");
            window.centerOnScreen();
            window.show();

        } catch (Exception e) {
            e.printStackTrace();
            e.getCause();
        }

    }
}
