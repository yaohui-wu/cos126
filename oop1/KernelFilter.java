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
    public static Picture gaussian(Picture picture) {}

    /**
     * Returns a new picture that applies a sharpen filter to the given
     * picture.
     */
    public static Picture sharpen(Picture picture) {}

    /**
     * Returns a new picture that applies an Laplacian filter to the given picture.
     */
    public static Picture laplacian(Picture picture) {}

    /**
     * Returns a new picture that applies an emboss filter to the given
     * picture.
     */
    public static Picture emboss(Picture picture) {}

    /**
     * Returns a new picture that applies a motion blur filter to the given
     * picture.
     */
    public static Picture motionBlur(Picture picture) {}

    /**
     * Returns a new picture that applies an arbitrary kernel filter to the
     * given picture.
     */
    private static Picture kernel(Picture picture, double[][] weights) {
        Picture pic = new Picture(picture);
        int w = pic.width();
        int h = pic.height();
        for (int i = 0; i < w; i++) {
            for (int j = 0; j < h; j++) {
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
        int rgb = red + green + blue;
        Color color = new Color(rgb);
        return color;
    }

    private static int kernelRGB(Picture pic, int row, int col, char primary, double[][] weights) {
        int rgb = 0;
        for (int i = row - 1; i < row + 2; i++) {
            for (int j = col - 1; j < col + 2; j++) {
                int m = i;
                int h = pic.height();
                if (m == -1 || m == h) {
                    m = wrapRow(i, h);
                }
                int n = j;
                int w = pic.width();
                if (n == -1 || n == h) {
                    n = wrapCol(j, w);
                }
                Color color = pic.get(m, n);
                int primaryVal = 0;
                if (primary == 'R') {
                    primaryVal = color.getRed();
                } else if (primary == 'G') {
                    primaryVal = color.getGreen();
                } else if (primary == 'B') {
                    primaryVal = color.getBlue();
                }
                if (primaryVal != 0) {
                    rgb += Math.round(primaryVal * weights[i][j]);
                }
            }
        }
        rgb = rgb(rgb);
        return rgb;
    }

    private static int wrapRow(int row, int height) {
        if (row == -1) {
            return height;
        } else if (row == height) {
            return 0;
        }
        return row;
    }

    private static int wrapCol(int col, int width) {
        if (col == -1) {
            return width;
        } else if (col == width) {
            return 0;
        }
        return col;
    }

    private static int rgb(int rgb) {
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
