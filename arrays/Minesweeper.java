public class Minesweeper {
    public static void main(String[] args) {
        /*
         * Generate an M-by-N grid of cells, with exactly K of the M * N cells
         * containing mines, uniformly at random.
         */
        int m = Integer.parseInt(args[0]);
        int n = Integer.parseInt(args[1]);
        int k = Integer.parseInt(args[2]);
        boolean[][] mines = new boolean[m + 2][n + 2];
        int[][] neighborMines = new int[m][n];
        for (int i = 0; i < k; i += 1) {
            int row = (int) (Math.random() * m) + 1;
            int col = (int) (Math.random() * n) + 1;
            if (!mines[row][col]) {
                mines[row][col] = true;
            }
        }
        for (int row = 1; row <= m; row += 1) {
            for (int col = 1; col <= n; col += 1) {
                for (int i = row - 1; i < row + 2; i += 1) {
                    for (int j = col - 1; j < col + 2; j += 1) {
                        if (i != j && mines[i][j]) {
                            neighborMines[row - 1][col - 1] += 1;
                        }
                    }
                }
            }
        }
        for (int row = 1; row <= m; row += 1) {
            for (int col = 1; col <= n; col += 1) {
                if (mines[row][col]) {
                    System.out.print("*");
                } else {
                    System.out.print(neighborMines[row - 1][col - 1]);
                }
                if (col < n) {
                    System.out.print("  ");
                }
            }
            System.out.println();
        }
    }
}
