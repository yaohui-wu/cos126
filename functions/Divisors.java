public class Divisors {
    /**
     * Returns the greatest common divisor of A and B.
     */
    public static int gcd(int a, int b) {
        // Euclidean algorithm.
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
        for (int i = 1; i < n; i += 1) {
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
        System.out.printf("gcd(%d,%d) = %d", a, b, gcd(a,b));
        System.out.printf("lcm(%d,%d) = %d", a, b, lcm(a,b));
        System.out.printf("areRelativelyPrime(%d,%d) = %d", a, b, areRelativelyPrime(a,b));
        System.out.printf("totient(%d) = %d", a, totient(a));
        System.out.printf("totient(%d) = %d", b, totient(b));
    }
}
