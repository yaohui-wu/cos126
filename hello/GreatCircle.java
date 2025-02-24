public class GreatCircle {
    public static void main(String[] args) {
        double x1 = Double.parseDouble(args[0]);
        double y1 = Double.parseDouble(args[1]);
        double x2 = Double.parseDouble(args[2]);
        double y2 = Double.parseDouble(args[3]);
        x1 = Math.toRadians(x1);
        y1 = Math.toRadians(y1);
        x2 = Math.toRadians(x2);
        y2 = Math.toRadians(y2);
        double greatCircDist = greatCircDist(x1, y1, x2, y2);
        System.out.println(greatCircDist + " kilometers");
    }

    /**
     * Computes the great-circle distance (in kilometers) between two points
     * on the surface of the earth.
     */
    private static double greatCircDist(
        double x1,
        double y1,
        double x2,
        double y2
    ) {
        // Haversine formula.
        double haversineX = haversine(x1, x2);
        double haversineY = haversine(y1, y2);
        haversineY *= Math.cos(x1) * Math.cos(x2);
        final double R = 6_371; // Mean radius of the Earth (in kilometers).
        double dist = 2 * R * Math.asin(Math.sqrt(haversineX + haversineY));
        return dist;
    }

    private static double haversine(double a, double b) {
        return Math.pow(Math.sin((b - a) / 2), 2);
    }
}
