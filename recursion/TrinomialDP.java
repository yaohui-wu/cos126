public class TrinomialDP {
    /**
     * Returns the trinomial coefficient T(N, K).
     */
    public static long trinomial(int n, int k) {
        long tri = 0;
        if (n == 0 && k == 0) {
            tri = 1;
            return tri;
        }
        k = Math.abs(k); // Fact: T(N, K) = T(N, -K).
        if (k > n) {
            return tri;
        }
        // Dynamic programming (bottom-up).
        long[][] tris = new long[n + 1][k + 2];
        tris[0][0] = 1;
        for (int i = 1; i < k + 2; i += 1) {
            tris[0][i] = 0;
        }
        for (int i = 1; i < n + 1; i += 1) {
            for (int j = 1; j < k + 1; j += 1) {
                tris[i][j] = 0;
            }
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
        System.out.println(tri);
    }
}
