public class GeneralizedHarmonic {
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        int r = Integer.parseInt(args[1]);
        // Compute the Nth generalized harmonic number of order R.
        double harmonic = 0;
        for (int i = 1; i <= n; i += 1) {
            harmonic += 1 / Math.pow(i, r);
        }
        System.out.println(harmonic);
    }
}
