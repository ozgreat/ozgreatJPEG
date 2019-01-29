package ozgreatJPEG.view;


import javafx.scene.control.Alert;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import java.io.File;

public class Dialog {
    public static void displayError(Exception ex) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText("Error");
        alert.setContentText(ex.getMessage());
        alert.show();
    }

    /**
     *Open FileChooser Dialog
     * @return file that you choose to open or save file
     */
    public static File fileChooserDialog(Stage stage) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Choose an image");
        fileChooser.getExtensionFilters().add(
                new FileChooser.ExtensionFilter("Images (*.bmp, *.png, *.gif, *.jpg)", "*.bmp", "*.png", "*.gif", "*.jpg")
        );
        return fileChooser.showOpenDialog(stage);
    }

    static void aboutDialog(){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("ABOUT");
        alert.setContentText("Written by ozgreat" +
                "\ntg: @ozgreat" +
                "\nTest by Despiad" +
                "\ntg: @Despiad");
        alert.setHeaderText("");
        alert.showAndWait();
    }

}
