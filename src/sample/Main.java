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

    private static Stage primaryStage;

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("openscreen.fxml")));

        //set bar icon
        Image barIcon = new Image(Objects.requireNonNull(LoginController.class.getResource("baricon.png")).toExternalForm(), false);
        primaryStage.getIcons().add(barIcon);

        primaryStage.setTitle("MOOWER");
        primaryStage.setScene(new Scene(root, 700, 500));
        primaryStage.show();

    }

    public void changeScene(String fxml) throws IOException {
        Parent pane = FXMLLoader.load(getClass().getResource(fxml));

        primaryStage.getScene().setRoot(pane);
    }

    public static void main(String[] args) {
        launch(args);
    }
}
