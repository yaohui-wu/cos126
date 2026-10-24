public class GreatCircle {
    /**
     * Computes the great-circle distance (in kilometers) between two points
     * on the surface of the earth.
     */
    public static void main(String[] args) {
        double x1 = Double.parseDouble(args[0]);
        double y1 = Double.parseDouble(args[1]);
        double x2 = Double.parseDouble(args[2]);
        double y2 = Double.parseDouble(args[3]);
        x1 = Math.toRadians(x1);
        y1 = Math.toRadians(y1);
        x2 = Math.toRadians(x2);
        y2 = Math.toRadians(y2);
        // Haversine formula.
        double haversineX = Math.pow(Math.sin((x2 - x1) / 2), 2);
        double haversineY = Math.pow(Math.sin((y2 - y1) / 2), 2);
        haversineY *= Math.cos(x1) * Math.cos(x2);
        // Mean radius of the Earth (in kilometers).
        final double R = 6_371.0;
        double dist = 2 * R * Math.asin(Math.sqrt(haversineX + haversineY));
        System.out.println(dist + " kilometers");
    }
}
