package ozgreatJPEG.model;

import ozgreatJPEG.view.Dialog;

import javax.imageio.IIOImage;
import javax.imageio.ImageIO;
import javax.imageio.ImageWriteParam;
import javax.imageio.ImageWriter;
import javax.imageio.stream.FileImageOutputStream;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;

class JpegCompress {
    private BufferedImage inputImage;
    private File newJpegFile;

    /**
     * JpegCompress constructor
     * @param myImage your input file
     * @param newJpegFile your future jpeg file
     */
    JpegCompress(File myImage, File newJpegFile) {
        try {
            inputImage = ImageIO.read(myImage);
        } catch (IOException inputImageEx) {
            Dialog.displayError(inputImageEx);
        }
        this.newJpegFile = newJpegFile;

    }

    /**
     * Compress image.
     * @param compressionQuality less value - bigger compression
     */
    void getCopression(float compressionQuality) throws IOException {
        newJpegFile  = Function.setFileName(newJpegFile);
        BufferedImage newBuff = new BufferedImage(inputImage.getWidth(), inputImage.getHeight(), BufferedImage.TYPE_INT_RGB);//to don't have problems
        newBuff.createGraphics().drawImage(inputImage, 0, 0, Color.WHITE, null);//color spaces
        Iterator<ImageWriter> iter = ImageIO.getImageWritersByFormatName("jpg");
        ImageWriter writer = iter.next();
        ImageWriteParam imageWriteParam = writer.getDefaultWriteParam();
        imageWriteParam.setCompressionMode(ImageWriteParam.MODE_EXPLICIT);
        imageWriteParam.setCompressionQuality(compressionQuality);// setting compression quality
        writer.setOutput(new FileImageOutputStream(newJpegFile));
        writer.write(null, new IIOImage(newBuff, null, null), imageWriteParam);
        writer.dispose();
    }
}
