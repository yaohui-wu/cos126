public class WorldMap {
    public static void main(String[] args) {
        int width = StdIn.readInt();
        int height = StdIn.readInt();
        StdDraw.setCanvasSize(width, height);
        StdDraw.setXscale(0, width);
        StdDraw.setYscale(0, height);
        StdDraw.enableDoubleBuffering();
        while (!StdIn.isEmpty()) {
            StdIn.readString(); // Skip the region name.
            int num = StdIn.readInt(); // Number of vertices.
            double[] xs = new double[num];
            double[] ys = new double[num];
            for (int i = 0; i < num; i += 1) {
                xs[i] = StdIn.readDouble();
                ys[i] = StdIn.readDouble();
            }
            StdDraw.polygon(xs, ys);
        }
        StdDraw.show();
    }
}
