public class RecursiveSquares {
    /**
     * Draws a square centered on (X, Y) of the given side LENGTH with a light
     * gray background and a black border.
     */
    public static void drawSquare(double x, double y, double length) {
        double halfLen = length / 2;
        StdDraw.setPenColor(StdDraw.LIGHT_GRAY);
        StdDraw.filledSquare(x, y, halfLen);
        StdDraw.setPenColor(StdDraw.BLACK);
        StdDraw.square(x, y, halfLen);
    }

    /**
     * Draws a recursive square pattern of order N, centered on (X, Y) of the
     * given side LENGTH.
     */
    public static void draw(int n, double x, double y, double length) {
        if (n == 1) {
            drawSquare(x, y, length);
        } else {
            double halfLen = length / 2;
            draw(n - 1, x - halfLen, y + halfLen, halfLen);
            draw(n - 1, x + halfLen, y + halfLen, halfLen);
            drawSquare(x, y, length);
            draw(n - 1, x - halfLen, y - halfLen, halfLen);
            draw(n - 1, x + halfLen, y - halfLen, halfLen);
        }
    }

    /**
     * Takes an integer command-line argument N and draws a recursive square
     * pattern of order N, centered on (0.5, 0.5) with side length 0.5.
     */
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        StdDraw.enableDoubleBuffering();
        draw(n, 0.5, 0.5, 0.5);
        StdDraw.show();
    }
}
