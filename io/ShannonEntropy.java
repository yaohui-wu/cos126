public class ShannonEntropy {
    public static void main(String[] args) {
        int m = Integer.parseInt(args[0]);
        int[] freq = new int[m]; // Frequencies.
        int count = 0;
        while (!StdIn.isEmpty()) {
            int i = StdIn.readInt();
            freq[i - 1] += 1;
            count += 1;
        }
        double h = 0.0; // Shannon entropy.
        for (int i = 0; i < m; i += 1) {
            int x = freq[i];
            if (x != 0) {
                double prop = (double) x / count; // Proportion.
                h += prop * (Math.log(prop) / Math.log(2));
            }
        }
        h = -h;
        StdOut.printf("%.4f\n", h);
    }
}
