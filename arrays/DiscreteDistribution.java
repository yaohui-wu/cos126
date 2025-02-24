public class DiscreteDistribution {
    public static void main(String[] args) {
        int m = Integer.parseInt(args[0]);
        int n = args.length - 1;
        int[] sums = new int[n + 1]; // Cumulative sums.
        sums[0] = 0;
        for (int i = 0; i < n; i += 1) {
            int ai = Integer.parseInt(args[i + 1]);
            sums[i + 1] = sums[i] + ai;
        }
        int count = 0;
        for (int i = 0; i < m; i += 1) {
            int r = (int) (Math.random() * (sums[n] - 1));
            // Binary search.
            int left = 1;
            int right = n;
            while (left < right) {
                int mid = left + (right - left) / 2;
                int lower = sums[mid - 1];
                int upper = sums[mid];
                if (lower <= r && r < upper) {
                    System.out.print(mid);
                    count += 1;
                    left = right + 1;
                } else if (r < lower) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
            if (left == right) {
                System.out.print(left);
                count += 1;
            }
            if (count == 25) {
                System.out.println();
                count = 0;
            } else {
                System.out.print(" ");
            }
        }
        if (count != 0) {
            System.out.println();
        }
    }
}
