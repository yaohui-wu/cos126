public class Ramanujan {
    /**
     * Is n a Ramanujan number?
     */
    public static boolean isRamanujan(long n) {
        int count = 0;
        int bound = (int) Math.round(Math.cbrt((double) n));
        for (int a = 1; a < bound; a++) {
            double b = Math.cbrt(n - Math.pow(a, 3.0));
            if (b == (int) b) {
                count += 1;
                if (count == 2) {
                    return true;
                }
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
