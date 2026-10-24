public class RightTriangle {
    public static void main(String[] args) {
        int a = Integer.parseInt(args[0]);
        int b = Integer.parseInt(args[1]);
        int c = Integer.parseInt(args[2]);
        boolean positive = a > 0 && b > 0 && c > 0;
        int max = Math.max(Math.max(a, b), c);
        int min = Math.min(Math.min(a, b), c);
        int mdn = a + b + c - max - min;
        boolean isRight = positive && (min * min + mdn * mdn == max * max);
        System.out.println(isRight);
    }
}
