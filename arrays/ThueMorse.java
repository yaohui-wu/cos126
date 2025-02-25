public class ThueMorse {
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        boolean[] thueMorse = new boolean[n];
        // Definition of the Thue–Morse sequence.
        thueMorse[0] = false;
        for (int i = 0; i < n; i += 1) {
            if (i % 2 == 0) {
                thueMorse[i] = thueMorse[i / 2];
            } else if (thueMorse[i - 1]) {
                thueMorse[i] = false;
            } else {
                thueMorse[i] = true;
            }
        }
        for (int row = 0; row < n; row += 1) {
            for (int col = 0; col < n; col += 1) {
                if (thueMorse[row] == thueMorse[col]) {
                    System.out.print("+");
                } else {
                    System.out.print("-");
                }
                if (col < n - 1) {
                    System.out.print("  ");
                }
            }
            System.out.println();
        }
    }
}
