public class BandMatrix {
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        int width = Integer.parseInt(args[1]);
        for (int row = 0; row < n; row += 1) {
            for (int col = 0; col < n; col += 1) {
                int dist = Math.abs(col - row);
                if (dist > width) {
                    System.out.print(0);
                } else {
                    System.out.print("*");
                }
                if (col < n - 1) {
                    System.out.print("  ");
                }
            }
            System.out.println();
        }
    }
}
