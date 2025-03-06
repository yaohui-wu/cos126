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
        for (int i = 0; i < n; i++) {
            p[i] = i;
        }
        if (k == 0) {
            return p;
        }
        int count = 0;
        int i = 0;
        int j = 1;
        while (count < k) {
            if (p[i] <= p[j]) {
                int temp = p[i];
                p[i] = p[j];
                p[j] = temp;
            }
            count += 1;
            j += 1;
            if (j == n) {
                i += 1;
                j = i + 1;
            }
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
