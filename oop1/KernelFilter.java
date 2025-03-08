import java.awt.Color;

public class KernelFilter {
    /**
     * Returns a new picture that applies the identity filter to the given
     * picture.
     */
    public static Picture identity(Picture picture) {
        return new Picture(picture);
    }

    /**
     * Returns a new picture that applies a Gaussian blur filter to the given
     * picture.
     */
    public static Picture gaussian(Picture picture) {
        double[][] weights = {
            {1.0, 2.0, 1.0},
            {2.0, 4.0, 2.0},
            {1.0, 2.0, 1.0}
        };
        double a = 1.0 / 16.0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                weights[i][j] *= a;
            }
        }
        Picture pic = kernel(picture, weights);
        return pic;
    }

    /**
     * Returns a new picture that applies a sharpen filter to the given
     * picture.
     */
    public static Picture sharpen(Picture picture) {
        double[][] weights = {
            {0.0, -1.0, 0.0},
            {-1.0, 5.0, -1.0},
            {0.0, -1.0, 0.0}
        };
        Picture pic = kernel(picture, weights);
        return pic;
    }

    /**
     * Returns a new picture that applies an Laplacian filter to the given picture.
     */
    public static Picture laplacian(Picture picture) {
        double[][] weights = {
            {-1.0, -1.0, -1.0},
            {-1.0, 8.0, -1.0},
            {-1.0, -1.0, -1.0}
        };
        Picture pic = kernel(picture, weights);
        return pic;
    }

    /**
     * Returns a new picture that applies an emboss filter to the given
     * picture.
     */
    public static Picture emboss(Picture picture) {
        double[][] weights = {
            {-2.0, -1.0, 0.0},
            {-1.0, 1.0, 1.0},
            {0.0, 1.0, 2.0}
        };
        Picture pic = kernel(picture, weights);
        return pic;
    }

    /**
     * Returns a new picture that applies a motion blur filter to the given
     * picture.
     */
    public static Picture motionBlur(Picture picture) {
        double a = 1.0 / 9.0;
        double[][] weights = new double[9][9];
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (i == j) {
                    weights[i][j] = a;
                }
            }
        }
        Picture pic = kernel(picture, weights);
        return pic;
    }

    /**
     * Returns a new picture that applies an arbitrary kernel filter to the
     * given picture.
     */
    private static Picture kernel(Picture picture, double[][] weights) {
        int width = picture.width();
        int height = picture.height();
        Picture pic = new Picture(width, height);
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                Color color = kernelRGB(picture, i, j, weights);
                pic.set(j, i, color);
            }
        }
        return pic;
    }

    private static Color kernelRGB(Picture pic, int row, int col, double[][] weights) {
        double newR = 0.0;
        double newG = 0.0;
        double newB = 0.0;
        int size = weights.length;
        int half = size / 2;
        // Compute a linear combination of the neighboring RGB components.
        for (int i = 0; i < size; i++) {
            // Periodic boundary conditions.
            int m = wrap(row - half + i, pic.height());
            for (int j = 0; j < size; j++) {
                int n = wrap(col - half + j, pic.width());
                Color color = pic.get(n, m);
                int red = color.getRed();
                int blue = color.getBlue();
                int green = color.getGreen();
                double weight = weights[i][j];
                newR += newRGB(red, weight);
                newG += newRGB(green, weight);
                newB += newRGB(blue, weight);
            }
        }
        int r = (int) Math.round(newR); // Red.
        r = rgb(r);
        int g = (int) Math.round(newG); // Green.
        g = rgb(g);
        int b = (int) Math.round(newB); // Blue.
        b = rgb(b);
        Color color = new Color(r, g, b);
        return color;
    }

    private static int wrap(int index, int length) {
        if (index < 0 || index >= length) {
            index = Math.floorMod(index, length);
        }
        return index;
    }

    private static double newRGB(int rgb, double weight) {
        if (rgb != 0 && weight != 0.0) {
            double newRGB = (double) rgb * weight;
            return newRGB;
        }
        return 0.0;
    }

    private static int rgb(int rgb) {
        // Saturation arithmetic.
        if (rgb < 0) {
            return 0;
        } else if (rgb > 255) {
            return 255;
        }
        return rgb;
    }

    /**
     * Test client.
     */
    public static void main(String[] args) {
        Picture picture = new Picture(args[0]);
        Picture identity = identity(picture);
        Picture gaussian = gaussian(picture);
        Picture sharpen = sharpen(picture);
        Picture laplacian = laplacian(picture);
        Picture emboss = emboss(picture);
        Picture motionBlur = motionBlur(picture);

        identity.show();
        gaussian.show();
        sharpen.show();
        laplacian.show();
        emboss.show();
        motionBlur.show();
    }
}
