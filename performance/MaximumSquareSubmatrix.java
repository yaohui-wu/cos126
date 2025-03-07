public class MaximumSquareSubmatrix {
    /**
     * Returns the size of the largest contiguous square submatrix of a[][]
     * containing only 1s.
     */
    public static int size(int[][] a) {
        // Dynamic programming.
        int n = a.length;
        if (n == 0) {
            return 0;
        }
        int[][] sizes = new int[n][n];
        /*
         * For each row i and column j, compute the size of the largest
         * contiguous square submatrix whose lower right endpoint is (i, j).
         */
        int size = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (a[i][j] == 1) {
                    if (i == 0 || j == 0) {
                        sizes[i][j] = 1;
                    } else {
                        int x = sizes[i - 1][j - 1];
                        int y = sizes[i - 1][j];
                        int z = sizes[i][j - 1];
                        sizes[i][j] = min(x, y, z) + 1;
                    }
                }
                if (sizes[i][j] > size) {
                    size = sizes[i][j];
                }
            }
        }
        return size;
    }

    private static int min(int x, int y, int z) {
        int min = Math.min(Math.min(x, y), Math.min(y, z));
        return min;
    }

    /**
     * Reads an n-by-n matrix of 0s and 1s from standard input and prints the
     * size of the largest contiguous square submatrix containing only 1s.
     */
    public static void main(String[] args) {
        int n = StdIn.readInt();
        int[][] a = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                a[i][j] = StdIn.readInt();
            }
        }
        int size = size(a);
        StdOut.println(size);
    }
}
