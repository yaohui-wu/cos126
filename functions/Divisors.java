public class Divisors {
    /**
     * Returns the greatest common divisor of A and B.
     */
    public static int gcd(int a, int b) {
        int gcd = 0;
        if (a == 0 && b == 0) {
            return gcd;
        }
        if (a == 1 || b == 1) {
            gcd = 1;
            return gcd;
        }
        a = Math.abs(a);
        b = Math.abs(b);
        // Euclidean algorithm.
        while (b != 0) {
            // Replace (A, B) with (B, A mod B).
            int temp = a;
            a = b;
            b = temp % b;
        }
        return a;
    }

    /**
     * Returns the least common multiple of A and B.
     */
    public static int lcm(int a, int b) {
        int lcm = 0;
        if (a == 0 && b == 0) {
            return lcm;
        }
        // Perform division first to avoid overflow.
        lcm = Math.abs(a) / gcd(a, b) * Math.abs(b);
        return lcm;
    }

    /**
     * Returns true if A and B are relatively prime; false otherwise.
     */
    public static boolean areRelativelyPrime(int a, int b) {
        return gcd(a, b) == 1;
    }

    /**
     * Returns the number of integers between 1 and N that are relatively
     * prime with N.
     */
    public static int totient(int n) {
        // Euler's totient function phi(n).
        int phi = 0;
        if (n <= 0) {
            return phi;
        }
        phi = 1;
        // 1 is relatively prime with any positive integer.
        for (int i = 2; i < n; i += 1) {
            if (areRelativelyPrime(i, n)) {
                phi += 1;
            }
        }
        return phi;
    }

    /**
     * Takes two integer command-line arguments A and B and prints each
     * function.
     */
    public static void main(String[] args) {
        int a = Integer.parseInt(args[0]);
        int b = Integer.parseInt(args[1]);
        String f = "gcd"; // Function.
        String format = "%s(%d, %d) = %d\n";
        System.out.printf(format, f, a, b, gcd(a,b));
        f = "lcm";
        System.out.printf(format, f, a, b, lcm(a,b));
        f = "areRelativelyPrime";
        format = "%s(%d, %d) = %b\n";
        boolean coprime = areRelativelyPrime(a, b);
        System.out.printf(format, f, a, b, coprime);
        f = "totient";
        format = "%s(%d) = %d\n";
        System.out.printf(format, f, a, totient(a));
        System.out.printf(format, f, b, totient(b));
    }
}
