import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.File;
import javax.imageio.ImageIO;

public class percentageCalc {
    public static void main(String [] args) throws IOException {
        BufferedImage img = ImageIO.read(new File("C:/Users/helio/Downloads/gibbs.jpg"));
        percentage(img);
    }

    private static void percentage(BufferedImage img) {
        int width = img.getWidth();
        int height = img.getHeight();
        String black = "#000000";

        int numOfPixels = 0;
        int totNumOfPixels = width * height;

        for (int row = 0; row < height; row++) {
            for (int col = 0; col < width; col++) {
                //Convert image to rgb for each pixel then String hex
                int color = img.getRGB(col, row);
                int blue = color & 0xff;
                int green = (color & 0xff00) >> 8;
                int red = (color & 0xff0000) >> 16;
                String hex = String.format("#%02x%02x%02x", red, green, blue);
                if (hex.equals(black)) {
                    numOfPixels++;
                }
            }
        }
        System.out.println("Number of black pixels: " + numOfPixels);
        System.out.println("Percentage: " + (double) numOfPixels/totNumOfPixels);
    }

    //Used to create new images
    public static void writeImage(BufferedImage image) {
        String path = "C:/Users/helio/Desktop/lolJerry.jpg";
        File ImageFile = new File(path);
        try {
            ImageIO.write(image, "jpg", ImageFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
