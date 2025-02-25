public class Birthday {
    public static void main(String[] args) {
        // Birthday problem.
        int n = Integer.parseInt(args[0]);
        int trials = Integer.parseInt(args[1]);
        int[] results = new int[n];
        for (int i = 0; i < trials; i += 1) {
            // Number of people with distinct birthdays.
            int people = 0;
            // At least 2 and at most N + 1 people for a shared birthday.
            boolean[] bdays = new boolean[n];
            int bday = (int) (Math.random() * n);
            while (!bdays[bday]) {
                bdays[bday] = true;
                people += 1;
                bday = (int) (Math.random() * n);
            }
            results[people - 1] += 1;
        }
        int count = 1;
        int sum = 0;
        double frac = 0.0;
        while (frac < 0.5) {
            System.out.println(count + "\t" + sum + "\t" + frac);
            count += 1;
            sum += results[count - 2];
            if (frac < 0.5) {
                frac = (double) sum / trials;
            }
        }
        System.out.println(count + "\t" + sum + "\t" + frac);
    }
}
