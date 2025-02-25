public class Birthday {
    public static void main(String[] args) {
        // Birthday problem.
        int n = Integer.parseInt(args[0]);
        int trials = Integer.parseInt(args[1]);
        int[] results = new int[n + 2];
        for (int i = 0; i < trials; i += 1) {
            int people = 0;
            boolean[] bdays = new boolean[n];
            int bday = (int) (Math.random() * n);
            while (!bdays[bday]) {
                bdays[bday] = true;
                people += 1;
                bday = (int) (Math.random() * n);
            }
            results[people] += 1;
        }
        int count = 1;
        int sum = 0;
        double frac = 0.0;
        while (frac < 0.5) {
            System.out.println(count + "\t" + sum + "\t" + frac);
            count += 1;
            sum += results[count - 1];
            if (frac < 0.5) {
                frac = (double) sum / trials;
            }
        }
        System.out.println(count + "\t" + sum + "\t" + frac);
    }
}
