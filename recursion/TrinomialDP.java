public class TrinomialDP {
    /**
     * Returns the trinomial coefficient T(N, K).
     */
    public static long trinomial(int n, int k) {
        long tri = 1;
        if (n == 0 && k == 0) {
            return tri;
        }
        if (k < -n || k > n) {
            tri = 0;
            return tri;
        }
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
