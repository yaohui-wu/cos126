public class RevesPuzzle {
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        reves(n, "A", "B", "C", "D");
    }

    private static void reves(
        int n,
        String from,
        String temp1,
        String temp2,
        String to
    ) {
        if (n == 0) {
            return;
        }
        // Frame–Stewart algorithm.
        int k = (int) Math.round(n + 1 - Math.sqrt(2 * n + 1));
        reves(k, from, temp1, to, temp2);
        hanoi(n - k, from, temp1, to);
        reves(k, temp2, from, temp1, to);
    }

    private static void hanoi(int n, String from, String temp, String to) {
        if (n == 0) {
            return;
        }
        hanoi(n - 1, from, to, temp);
        StdOut.printf("Move disc %d from %s to %s\n", n, from, to);
        hanoi(n - 1, temp, from, to);
    }
}
