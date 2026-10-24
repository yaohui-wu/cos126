public class RevesPuzzle {
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        reves(n, 'A', 'B', 'C', 'D');
    }

    /**
     * Solves the Tower of Hanoi problem with four poles (Reve's puzzle) using
     * the optimal Frame-Stewart algorithm.
     */
    private static void reves(
        int n,
        char from,
        char aux1,
        char aux2,
        char to
    ) {
        if (n == 0) {
            return;
        }
        // Frame–Stewart algorithm.
        int k = (int) Math.round(n + 1 - Math.sqrt(2 * n + 1));
        /*
         * Move the K smallest discs to an auxiliary pole (other than the
         * start or destination poles).
         */
        reves(k, from, aux1, to, aux2);
        /*
         * Move the remaining largest N − K discs to the destination pole,
         * without using the pole that now contains the smallest K discs.
         */
        hanoi(n, k, from, aux1, to);
        /*
         * Move the K smallest discs to the destination pole.
         */
        reves(k, aux2, from, aux1, to);
    }

    /**
     * Moves N - K largest discs to the destination pole using the Tower of
     * Hanoi algorithm.
     */
    private static void hanoi(int n, int k, char from, char aux, char to) {
        if (n == k) {
            return;
        }
        hanoi(n - 1, k, from, to, aux);
        StdOut.printf("Move disc %d from %c to %c\n", n, from, to);
        hanoi(n - 1, k, aux, from, to);
    }
}
