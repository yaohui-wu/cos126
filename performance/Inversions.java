public class Inversions {
    /**
     * Return the number of inversions in the permutation a[].
     */
    public static long count(int[] a) {
        long count = 0;
        int length = a.length;
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                if (i < j && a[i] > a[j]) {
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
            StdOut.print(p[i] + " ");
        }
    }
}
