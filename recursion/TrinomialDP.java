public class TrinomialDP {
    /**
     * Returns the trinomial coefficient T(N, K).
     */
    public static long trinomial(int n, int k) {
        long tri = 0;
        // T(N, K) = T(N, -K).
        k = Math.abs(k);
        if (n < k) {
            return tri;
        }
        // T(N, N) = 1.
        if (n == k) {
            tri = 1;
            return tri;
        }
        int size = n + 1;
        long[][] tris = new long[size][]; // Trinomial triangle.
        for (int i = 0; i < size; i += 1) {
            tris[i] = new long[i + 1];
        }
        // Dynamic programming (bottom-up).
        tris[0][0] = 1;
        // T(N, K) = T(N - 1, K - 1) + T(N - 1, K) + T(N - 1, K + 1).
        for (int i = 1; i < size; i += 1) {
            for (int j = 0; j < tris[i].length; j += 1) {
                long t = 1;
                if (i != j) {
                    t = 0;
                    int m = i - 1;
                    int len = tris[m].length;
                    if (j - 1 < 0 && j + 1 < len) {
                        t += tris[m][j + 1];
                    } else if (j - 1 >= 0) {
                        t += tris[m][j - 1]; // T(N - 1, K - 1).
                    }
                    if (j < len) {
                        t += tris[m][j]; // T(N - 1, K).
                    }
                    if (j + 1 < len) {
                        t += tris[m][j + 1]; // T(N - 1, K + 1).
                    }
                }
                tris[i][j] = t;
            }
        }
        // TODO: Show output for debugging (remove this after algorithm works).
        for (int i = 0; i < size; i += 1) {
            for (int j = 0; j < tris[i].length; j += 1) {
                System.out.print(tris[i][j] + " ");
            }
            System.out.println();
        }
        tri = tris[n][k];
        return tri;
    }

    /**
     * Takes two integer command-line arguments N and K and prints T(N, K).
     */
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        int k = Integer.parseInt(args[1]);
        long tri = trinomial(n, k);
        // TODO: Show output for debugging (change this after algorithm works).
        System.out.printf("T(%d, %d) = %d\n", n, k, tri);
    }
}
