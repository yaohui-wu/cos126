public class RevesPuzzle {
    private static void RevesPuzzle(int n) {
        int k = (int) Math.round(n + 1 - Math.sqrt(2 * n + 1));
    }
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
    }
}
