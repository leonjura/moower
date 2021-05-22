package sample;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;

public class OpenscreenController implements Initializable {

    @FXML
    private ImageView brandingImageView;
    @FXML
    private ImageView padlockImageView;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        File brandingFile = new File("img/moowericon.png");
        Image brandingImage = new Image(brandingFile.toURI().toString());
        brandingImageView.setImage(brandingImage);

        File padlockFile = new File("img/padlock.png");
        Image padlockImage = new Image(padlockFile.toURI().toString());
        padlockImageView.setImage(padlockImage);
    }


}
