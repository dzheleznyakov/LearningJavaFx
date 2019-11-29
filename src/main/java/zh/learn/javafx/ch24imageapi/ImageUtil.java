package zh.learn.javafx.ch24imageapi;

import javafx.embed.swing.SwingFXUtils;
import javafx.scene.image.Image;
import javafx.stage.FileChooser;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ImageUtil {
    public static void saveToFile(Image image) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Select an image file name");
        fileChooser.setInitialFileName("untitled");
        FileChooser.ExtensionFilter pngExt = new FileChooser.ExtensionFilter("PNG Files", "*.png");
        FileChooser.ExtensionFilter jpgExt = new FileChooser.ExtensionFilter("JPEG Files", "*.jpg", "*.jpeg");
        fileChooser.getExtensionFilters().addAll(pngExt, jpgExt);

        File outputFile = fileChooser.showSaveDialog(null);
        if (outputFile == null) {
            return;
        }

        FileChooser.ExtensionFilter selectedExt = fileChooser.getSelectedExtensionFilter();
        String imageFormat = "png";
        if (selectedExt == jpgExt) {
            imageFormat = "jpg";
        }

        String fileName = outputFile.getName().toLowerCase();
        switch (imageFormat) {
            case "jpg":
                if (!fileName.endsWith(".jpeg") && !fileName.endsWith(".jpg")) {
                    outputFile = new File(outputFile.getParentFile(), outputFile.getName() + ".jpg");
                }
                break;
            case "png":
                if (!fileName.endsWith(".png")) {
                    outputFile = new File(outputFile.getParentFile(), outputFile.getName() + ".png");
                }
        }

        BufferedImage bImage = SwingFXUtils.fromFXImage(image, null);

        try {
            ImageIO.write(bImage, imageFormat, outputFile);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
