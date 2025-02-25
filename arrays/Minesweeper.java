public class Minesweeper {
    public static void main(String[] args) {
        int m = Integer.parseInt(args[0]);
        int n = Integer.parseInt(args[1]);
        int k = Integer.parseInt(args[2]);
        /*
         * Generate an M-by-N grid of cells, with exactly K of the M * N cells
         * containing mines, uniformly at random.
         */
        int[][] cells = new int[m + 2][n + 2];
        for (int i = 0; i < k; i += 1) {
            int row = (int) (Math.random() * m) + 1;
            int col = (int) (Math.random() * n) + 1;
            if (cells[row][col] != -1) {
                cells[row][col] = -1; // Put a mine.
            }
        }
        for (int row = 1; row <= m; row += 1) {
            for (int col = 1; col <= n; col += 1) {
                if (cells[row][col] == -1) {
                    if (cells[row - 1][col - 1] != -1) {
                        cells[row - 1][col - 1] += 1;
                    }
                    if (cells[row - 1][col] != -1) {
                        cells[row - 1][col] += 1;
                    }
                    if (cells[row - 1][col + 1] != -1) {
                        cells[row - 1][col + 1] += 1;
                    }
                    if (cells[row - 1][col - 1] != -1) {
                        cells[row - 1][col - 1] += 1;
                    }
                    if (cells[row - 1][col + 1] != -1) {
                        cells[row - 1][col + 1] += 1;
                    }
                    if (cells[row + 1][col - 1] != -1) {
                        cells[row + 1][col - 1] += 1;
                    }
                    if (cells[row + 1][col] != -1) {
                        cells[row + 1][col] += 1;
                    }
                    if (cells[row + 1][col + 1] != -1) {
                        cells[row + 1][col + 1] += 1;
                    }
                }
            }
        }
        for (int row = 1; row <= m; row += 1) {
            for (int col = 1; col <= n; col += 1) {
                int cell = cells[row][col];
                if (cell == -1) {
                    System.out.print("*");
                } else {
                    System.out.print(cell);
                }
                if (col < n) {
                    System.out.print("  ");
                }
            }
            System.out.println();
        }
    }
}
