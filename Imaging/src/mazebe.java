import java.awt.*;
import java.util.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.File;
import javax.imageio.ImageIO;

public class mazebe {
    public static void main(String [] args) throws IOException {
        BufferedImage img = ImageIO.read(new File("C:/Users/helio/Desktop/checkerboard.png"));
        // Loop through all rows
        for (int[] row : findPos(img))

            // converting each row as string
            // and then printing in a separate line
            System.out.println(Arrays.toString(row));
    }

    private static int[][] findPos(BufferedImage img) {
        int width = img.getWidth();
        int height = img.getHeight();
        int[][] pic = new int[height][width];

        String black = "#000000";
        for (int row = 0; row < width; row++) {
            for (int col = 0; col < height; col++) {
                //Convert image to rgb for each pixel then String hex
                int color = img.getRGB(col, row);
                int blue = color & 0xff;
                int green = (color & 0xff00) >> 8;
                int red = (color & 0xff0000) >> 16;
                String hex = String.format("#%02x%02x%02x", red, green, blue);
                if (hex.equals(black)) {
                    pic[col][row] = 1;
                }
            }
        }

        return pic;
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
