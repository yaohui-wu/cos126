/**
 * Represents a color in hue–saturation–brightness (HSB) format.
 * 
 * @author Yaohui Wu
 */
public final class ColorHSB {
    private final int hue;
    private final int saturation;
    private final int brightness;

    /**
     * Creates a color with hue h, saturation s, and brightness b.
     */
    public ColorHSB(int h, int s, int b) {
        validateHSB(h, s, b);
        hue = h;
        saturation = s;
        brightness = b;
    }

    private void validateHSB(int h, int s, int b) {
        validateHue(h);
        validateSaturation(s);
        validateBrightness(b);
    }

    private void validateHue(int h) {
        if (h < 0 || h > 359) {
            String error = "The hue must be between 0 and 359";
            throw new IllegalArgumentException(error);
        }
    }

    private void validateSaturation(int s) {
        if (s < 0 || s > 100) {
            String error = "The saturation must be between 0 and 100";
            throw new IllegalArgumentException(error);
        }
    }

    private void validateBrightness(int b) {
        if (b < 0 || b > 100) {
            String error = "The brightness must be between 0 and 100";
            throw new IllegalArgumentException(error);
        }
    }

    /**
     * Returns a string representation of this color, using the format (h, s,
     * b).
     */
    public String toString() {
        return String.format("(%d, %d, %d)", hue, saturation, brightness);
    }

    /**
     * Is this color a shade of gray?
     */
    public boolean isGrayscale() {
        return saturation == 0 || brightness == 0;
    }

    /**
     * Returns the squared distance between the two colors.
     */
    public int distanceSquaredTo(ColorHSB that) {
        validateArg(that);
        int h = hue - that.hue;
        int x = Math.min(h * h, square(360 - Math.abs(h)));
        int y = square(saturation - that.saturation);
        int z = square(brightness - that.brightness);
        int dist = x + y + z;
        return dist;
    }

    private int square(int x) {
        return x * x;
    }

    private void validateArg(Object arg) {
        if (arg == null) {
            String error = "Argument cannot be null";
            throw new IllegalArgumentException(error);
        }
    }

    /**
     * Takes three integer command-line arguments h, s, and b; read a list of
     * pre-defined colors from standard input; and print to standard output
     * the pre-defined color that is closest to (h, s, b).
     */
    public static void main(String[] args) {
        int hue = Integer.parseInt(args[0]);
        int saturation = Integer.parseInt(args[1]);
        int brightness = Integer.parseInt(args[2]);
        ColorHSB color = new ColorHSB(hue, saturation, brightness);
        int min = Integer.MAX_VALUE;
        String nearestName = null;
        ColorHSB nearest = null;
        while (!StdIn.isEmpty()) {
            String name = StdIn.readString();
            int h = StdIn.readInt();
            int s = StdIn.readInt();
            int b = StdIn.readInt();
            ColorHSB c = new ColorHSB(h, s, b);
            int dist = color.distanceSquaredTo(c);
            if (dist < min) {
                min = dist;
                nearestName = name;
                nearest = c;
            }
        }
        StdOut.printf("%s ", nearestName);
        StdOut.println(nearest);
    }
}
