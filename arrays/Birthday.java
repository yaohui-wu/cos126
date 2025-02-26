public class Birthday {
    public static void main(String[] args) {
        // Birthday problem.
        int n = Integer.parseInt(args[0]);
        int trials = Integer.parseInt(args[1]);
        int[] results = new int[n];
        for (int i = 0; i < trials; i += 1) {
            int people = 0;
            // At least 2 and at most N + 1 people for a shared birthday.
            boolean[] bdays = new boolean[n];
            boolean shared = false;
            while (!shared) {
                int bday = (int) (Math.random() * n);
                if (bdays[bday]) {
                    shared = true;
                } else {
                    bdays[bday] = true;
                }
                people += 1;
            }
            results[people - 2] += 1;
        }
        int count = 1;
        int sum = 0;
        double frac = 0.0;
        System.out.println(count + "\t" + sum + "\t" + frac);
        while (frac < 0.5) {
            count += 1;
            int result = results[count - 2];
            sum += result;
            frac = (double) sum / trials;
            System.out.println(count + "\t" + result + "\t" + frac);
        }
    }
}
