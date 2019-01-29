package ozgreatJPEG.view;

import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import ozgreatJPEG.Main;
import ozgreatJPEG.model.Function;
import java.io.File;

public class Controller {
    private File inputFile;

    @FXML
    private ComboBox<String> compressionBox;

    @FXML
    private void initialize(){
        ObservableList<String> compressionValueList = FXCollections.observableArrayList("0.1", "0.2", "0.3", "0.4", "0.5", "0.6", "0.7", "0.8", "0.9", "1.0");
        compressionBox.setItems(compressionValueList);
        compressionBox.setValue("0.5");
    }

    @FXML
    private void fileOpen(){
        inputFile = Dialog.fileChooserDialog(Main.primary);
    }

    @FXML
    private void showAbout(){
        Dialog.aboutDialog();
    }

    @FXML
    private void close(){
        Platform.exit();
    }

    @FXML
    private void compress(){
        Function.getCompress(inputFile, Float.parseFloat(compressionBox.getValue()));
    }

}
