import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.File;
import java.util.Arrays;
import javax.imageio.ImageIO;

public class allBlack {

    public static void main(String [] args) throws IOException {
//        BufferedImage whitePic = ImageIO.read(new File("C:/Users/helio/Desktop/RiskImages/BlankWhite.jpg"));
        BufferedImage img = ImageIO.read(new File("C:/Users/helio/Desktop/RiskImages/CleanUSMap.jpg"));
        pic(img);
        writeImage(img);
//        System.out.println(Arrays.deepToString(pic(img)));
    }

    static void pic(BufferedImage img) {
        int width = img.getWidth();
        int height = img.getHeight();
        String black = "#000000";
        String blackish = "#050505";
        String black10 = "#0A0A0A";
        String black15 = "0F0F0F";
        

        for (int row = 0; row < height; row++) {
            for (int col = 0; col < width; col++) {
                //Convert image to rgb for each pixel then String hex
                int color = img.getRGB(col, row);
                int blue = color & 0xff;
                int green = (color & 0xff00) >> 8;
                int red = (color & 0xff0000) >> 16;
                int avgGray = (int) (red + green + blue)/3;
//                String hex = String.format("#%02x%02x%02x", avgGray, avgGray, avgGray);
                if (avgGray > 100) {
                    img.setRGB(col, row, Color.white.getRGB());
                }
            }
        }

    }
    
//    static void idunno(BufferedImage whitePic, BufferedImage img) {
//        int width = img.getWidth();
//        int height = img.getHeight();
//
//        for (int row = 0; row < height; row++) {
//            for (int col = 0; col < width; col++) {
////                System.out.println("done");
//                if (pic(img)[row][col] == 1) {
//                    whitePic.setRGB(col, row, 0);
////                    System.out.println("Row - " + row);
////                    System.out.println("Col - " + col);
////                    System.out.println();
//                }
//            }
//        }
//    }

    //Used to create new images
    static void writeImage(BufferedImage image) {
        String path = "C:/Users/helio/Desktop/test.jpg";
        File ImageFile = new File(path);
        try {
            ImageIO.write(image, "jpg", ImageFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
