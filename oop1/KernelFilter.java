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
        double a = 1.0 / 6.0;
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
        Picture pic = new Picture(picture);
        int w = pic.width();
        int h = pic.height();
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                Color color = kernelColor(pic, i, j, weights);
                pic.set(j, i, color);
            }
        }
        return pic;
    }

    private static Color kernelColor(Picture pic, int row, int col, double[][] weights) {
        int red = kernelRGB(pic, row, col, 'R', weights);
        int green = kernelRGB(pic, row, col, 'G', weights);
        int blue = kernelRGB(pic, row, col, 'B', weights);
        Color color = new Color(red, green, blue);
        return color;
    }

    private static int kernelRGB(Picture pic, int row, int col, char primary, double[][] weights) {
        int rgb = 0;
        int size = weights.length;
        // Compute a linear combination of its neighboring RGB components.
        for (int i = 0; i < size; i++) {
            // Periodic boundary conditions.
            int m = wrap(row - 1 + i, pic.height());
            for (int j = 0; j < size; j++) {
                int n = wrap(col - 1 + j, pic.width());
                Color color = pic.get(n, m);
                int primaryVal = 0;
                if (primary == 'R') {
                    primaryVal = color.getRed();
                } else if (primary == 'G') {
                    primaryVal = color.getGreen();
                } else if (primary == 'B') {
                    primaryVal = color.getBlue();
                }
                double weight = weights[i][j];
                if (primaryVal != 0 && weight != 0.0) {
                    rgb += (int) Math.round((double) primaryVal * weight);
                }
            }
        }
        rgb = rgb(rgb);
        return rgb;
    }

    private static int wrap(int index, int length) {
        if (index < 0 || index >= length) {
            index = Math.floorMod(index, length);
        }
        return index;
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
