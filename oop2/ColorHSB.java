/**
 * Represents a color in hue–saturation–brightness (HSB) format.
 * 
 * @author Yaohui Wu
 */
public class ColorHSB {
    private int hue;
    private int saturation;
    private int brightness;

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
        validateComponents(359, h);
        validateComponents(100, s, b);
    }

    private void validateComponents(int max, int... values) {
        for (int val : values) {
            if (val < 0 || val >= max) {
                String error = "Component value out of range";
                throw new IllegalArgumentException(error);
            }
        }
    }

    /**
     * Returns a string representation of this color, using the format (h, s,
     * b).
     */
    public String toString() {
        StringBuilder s = new StringBuilder();
        s.append("(");
        s.append(hue);
        s.append(", ");
        s.append(saturation);
        s.append(", ");
        s.append(brightness);
        s.append(")");
        return s.toString();
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
        int h = Integer.parseInt(args[0]);
        int s = Integer.parseInt(args[1]);
        int b = Integer.parseInt(args[2]);
        ColorHSB color = new ColorHSB(h, s, b);
    }
}
