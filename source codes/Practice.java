package ASimulatorSystem;

import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;

public final class Practice {

    private boolean negative;

    public Practice() {
        this(false);
    }

    public Practice(boolean negative) {
        this.negative = negative;
    }

    public String convert(BufferedImage image) {

        StringBuilder result = new StringBuilder();

        for (int y = 0; y < image.getHeight(); y++) {

            for (int x = 0; x < image.getWidth(); x++) {

                int pixel = image.getRGB(x, y);

                int red = (pixel >> 16) & 0xff;
                int blue = (pixel >> 8) & 0xff;
                int green = pixel & 0xff;

                double gray = red * 0.2989 + blue * 0.587 + green * 0.114;

                if (negative) {
                    gray = 255 - gray;
                }

                result.append(returnStrPos(gray));
            }

            result.append('\n');
        }

        return result.toString();
    }

    private char returnStrPos(double value) {

        if (value < 30) return '@';
        if (value < 60) return '#';
        if (value < 90) return '8';
        if (value < 120) return '&';
        if (value < 150) return 'o';
        if (value < 180) return ':';
        if (value < 210) return '*';
        if (value < 240) return '.';

        return ' ';
    }

    private char returnStrNeg(double value) {
        return returnStrPos(255 - value);
    }

    public static void main(String[] args) {

        try {

            String fileName;

            if (args.length > 0) {
                fileName = args[0];
            } else {
                fileName = Input.readLine("Enter image file path: ");
            }

            String negativeInput = Input.readLine(
                    "Convert as negative image? (Yes/No): ");

            boolean negative = negativeInput.equalsIgnoreCase("Yes");

            BufferedImage image = ImageIO.read(new File(fileName));

            if (image == null) {
                System.out.println("Could not read the image.");
                return;
            }

            Practice practice = new Practice(negative);
            System.out.println(practice.convert(image));

        } catch (Exception e) {
            System.out.println("Unable to process the image.");
            e.printStackTrace();
        }
    }
}
