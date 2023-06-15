import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.File;
import javax.imageio.ImageIO;

public class Main {
    public static void main(String [] args) throws IOException {
        BufferedImage image = ImageIO.read(new File("C:/Users/helio/Desktop/jerry.jpg"));
        blue(image);
        writeImage(image);
    }

    private static void blue(BufferedImage image) {
        int width = image.getWidth();
        int height = image.getHeight();
        //int blue = 0xFF0000FF;
        //int color = image.getRGB(width/2, height/2);

// Components will be in the range of 0..255:

        int black = 0x000000;
        //System.out.println(red + ", " + green + ", " + blue);
        for (int row = 0; row < height; row++) {
            for (int col = 0; col < width; col++) {
                int color = image.getRGB(col, row);
                int blue = color & 0xff;
                int green = (color & 0xff00) >> 8;
                int red = (color & 0xff0000) >> 16;

                Color thingy = new Color(green, blue, red);
                int thingyInt = thingy.getRGB();
                image.setRGB(col, row, thingyInt);
            }
        }
    }

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
