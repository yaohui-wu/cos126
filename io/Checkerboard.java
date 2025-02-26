public class Checkerboard {
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        StdDraw.setScale(0, n);
        double halfLength = 0.5;
        for (int row = 0; row < n; row += 1) {
            for (int col = 0; col < n; col += 1) {
                if ((row + col) % 2 == 0) {
                    StdDraw.setPenColor(StdDraw.BLUE);
                } else {
                    StdDraw.setPenColor(StdDraw.LIGHT_GRAY);
                }
                double x = row + halfLength;
                double y = col + halfLength;
                StdDraw.filledSquare(x, y, halfLength);
            }
        }
    }
}
