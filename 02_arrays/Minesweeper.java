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
        int count = 0;
        while (count < k) {
            int index = (int) (Math.random() * (m * n));
            int row = index / n + 1;
            int col = index % n + 1;
            if (cells[row][col] != -1) {
                cells[row][col] = -1; // Put a mine.
                count += 1;
            }
        }
        for (int row = 1; row <= m; row += 1) {
            for (int col = 1; col <= n; col += 1) {
                if (cells[row][col] != -1) {
                    // Count the number of mines in the 8 neighboring cells.
                    if (cells[row - 1][col - 1] == -1) {
                        cells[row][col] += 1;
                    }
                    if (cells[row - 1][col] == -1) {
                        cells[row][col] += 1;
                    }
                    if (cells[row - 1][col + 1] == -1) {
                        cells[row][col] += 1;
                    }
                    if (cells[row][col - 1] == -1) {
                        cells[row][col] += 1;
                    }
                    if (cells[row][col + 1] == -1) {
                        cells[row][col] += 1;
                    }
                    if (cells[row + 1][col - 1] == -1) {
                        cells[row][col] += 1;
                    }
                    if (cells[row + 1][col] == -1) {
                        cells[row][col] += 1;
                    }
                    if (cells[row + 1][col + 1] == -1) {
                        cells[row][col] += 1;
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
