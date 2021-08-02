package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class Main extends Application {


    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("openscreen.fxml")));

        Scene scene = new Scene(root);

        //set bar icon
        Image barIcon = new Image(Objects.requireNonNull(LoginController.class.getResource("baricon.png")).toExternalForm(), false);
        primaryStage.getIcons().add(barIcon);

        primaryStage.setTitle("MOOWER");
        primaryStage.setScene(scene);
        primaryStage.centerOnScreen();
        primaryStage.show();

    }

    public static void main(String[] args) {
        launch(args);
    }
}
