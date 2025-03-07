public class Inversions {
    /**
     * Return the number of inversions in the permutation a[].
     */
    public static long count(int[] a) {
        long count = 0;
        int length = a.length;
        for (int i = 0; i < length; i++) {
            for (int j = i + 1; j < length; j++) {
                if (a[i] > a[j]) {
                    count += 1;
                }
            }
        }
        return count;
    }

    /**
     * Return a permutation of length n with exactly k inversions.
     */
    public static int[] generate(int n, long k) {
        int[] p = new int[n]; // Permutation.
        if (n == 0) {
            return p;
        }
        // Greedy algorithm.
        int i = n - 1;
        int j = 0;
        while (i > j) {
            if (k >= i) {
                p[j] = i;
                k -= i;
                i += 1;
                j += 1;
            } else {
                p[i] = i - j;
            }
            i -= 1;
        }
        return p;
    }

    /**
     * Takes an integer n and a long k as command-line arguments, and prints a
     * permutation of length n with exactly k inversions.
     */
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        long k = Long.parseLong(args[1]);
        int[] p = generate(n, k);
        StdOut.println(count(p));
        for (int i = 0; i < n; i++) {
            StdOut.print(p[i]);
            if (i < n - 1) {
                StdOut.print(" ");
            } else {
                StdOut.println();
            }
        }
    }
}
