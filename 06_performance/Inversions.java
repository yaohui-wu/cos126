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
        if (n == 0) {
            return new int[0];
        }
        int[] p = new int[n]; // Permutation.
        // Greedy algorithm.
        int element = n - 1;
        int i = n - 1;
        int j = 0;
        while (i > j) {
            if (k >= element) {
                // Put the larger element at the beginning to get inversions.
                p[j] = element;
                k -= element;
                j += 1;
            } else {
                p[i] = element;
                i -= 1;
            }
            element -= 1;
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
