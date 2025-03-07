public class Ramanujan {
    /**
     * Is n a Ramanujan number?
     */
    public static boolean isRamanujan(long n) {
        int count = 0;
        int c = 0;
        double cbrt = Math.cbrt((double) n);
        // Check if n is the sum of two positive cubes in two different ways.
        for (long a = 1; a < cbrt; a++) {
            double b = Math.cbrt(n - a * a * a);
            if (b == (int) b && a != c) {
                count += 1;
                if (count == 2) {
                    return true;
                }
                c = (int) b;
            }
        }
        return false;
    }

    /**
     * Takes a long integer command-line arguments n and prints true if n is a
     * Ramanujan number, and false otherwise.
     */
    public static void main(String[] args) {
        long n = Long.parseLong(args[0]);
        StdOut.println(isRamanujan(n));
    }
}
