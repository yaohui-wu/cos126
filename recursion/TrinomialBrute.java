public class TrinomialBrute {
    /**
     * Returns the trinomial coefficient T(N, K).
     */
    public static long trinomial(int n, int k) {
        // Base cases.
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
        // Recurrence relation.
        int m = n - 1;
        // T(N, K) = T(N - 1, K - 1) + T(N - 1, K) + T(N - 1, K + 1).
        tri = trinomial(m, k - 1) + trinomial(m, k) + trinomial(m, k + 1);
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
