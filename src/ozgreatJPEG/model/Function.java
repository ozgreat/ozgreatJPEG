package ozgreatJPEG.model;

import ozgreatJPEG.Main;
import ozgreatJPEG.view.Dialog;

import java.io.File;


public class Function {
    /**
     * @param file is output file, that you choose at getCompress()
     *This method add ".jpg" to filename, if filename doesn't end with ".jpg"
     */
    static File setFileName(File file) {
        try {
            if (file.getPath().endsWith(".png")) {
                file = new File(file.getPath().replace(".png", ".jpg"));
            } else if (file.getPath().endsWith(".bmp")) {
                file = new File(file.getPath().replace(".bmp", ".jpg"));
            } else if (file.getPath().endsWith(".gif")) {
                file = new File(file.getPath().replace(".gif", ".jpg"));
            } else {
                file = new File(file.getPath() + ".jpg");
            }
        } catch (NullPointerException ex) {
            Dialog.displayError(ex);
        }
        return file;
    }

    /**
     * Create output file and compress input file by JpegCompressor
     * @param inputFile your input file
     * @param compressionValue value from ComboBox
     */
    public static void getCompress(File inputFile, float compressionValue){
        File outputFile = Dialog.fileChooserDialog(Main.primary);
        JpegCompress jpegCompress = new JpegCompress(inputFile, outputFile);
        try {
            jpegCompress.getCopression(compressionValue);
        }catch (Exception ex){
            Dialog.displayError(ex);
        }
    }

}
