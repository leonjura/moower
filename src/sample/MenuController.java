package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

public class MenuController implements Initializable {


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    public void casesButtonOnAction(ActionEvent event) {
        try {
            Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("cases.fxml")));
            Stage casesStage = new Stage();
            casesStage.setTitle("MOOWER");
            casesStage.setScene(new Scene(root, 520, 400));
            casesStage.show();
            // Hide current window
            // ((Node)(event.getSource())).getScene().getWindow().hide();
        } catch (Exception e) {
            e.printStackTrace();
            e.getCause();
        }
    }

    public void toolsButtonOnAction(ActionEvent event) {
        try {
            Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("tools.fxml")));
            Stage toolsStage = new Stage();
            toolsStage.setTitle("MOOWER");
            toolsStage.setScene(new Scene(root, 520, 400));
            toolsStage.show();
            // Hide current window
            // ((Node)(event.getSource())).getScene().getWindow().hide();
        } catch (Exception e) {
            e.printStackTrace();
            e.getCause();
        }
    }

    public void customersButtonOnAction(ActionEvent event) {
        try {
            Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("customers.fxml")));
            Stage customersStage = new Stage();
            customersStage.setTitle("MOOWER");
            customersStage.setScene(new Scene(root, 520, 400));
            customersStage.show();
            // Hide current window
            // ((Node)(event.getSource())).getScene().getWindow().hide();
        } catch (Exception e) {
            e.printStackTrace();
            e.getCause();
        }
    }

    public void servicesButtonOnAction(ActionEvent event) {
        try {
            Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("services.fxml")));
            Stage servicesStage = new Stage();
            servicesStage.setTitle("MOOWER");
            servicesStage.setScene(new Scene(root, 520, 400));
            servicesStage.show();
            // Hide current window
            // ((Node)(event.getSource())).getScene().getWindow().hide();
        } catch (Exception e) {
            e.printStackTrace();
            e.getCause();
        }
    }

    public void logOutButtonOnAction(ActionEvent event) {
        try {
            Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("openscreen.fxml")));
            Stage openscreenStage = new Stage();
            openscreenStage.setTitle("MOOWER");
            openscreenStage.setScene(new Scene(root, 520, 400));
            openscreenStage.show();
            // Hide current window
            // ((Node)(event.getSource())).getScene().getWindow().hide();
        } catch (Exception e) {
            e.printStackTrace();
            e.getCause();
        }
    }
}
