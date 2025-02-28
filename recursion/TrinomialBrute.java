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
        tri = trinomial(n - 1, k - 1) + trinomial(n - 1, k);
        tri += trinomial(n - 1, k + 1);
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
