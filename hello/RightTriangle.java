public class RightTriangle {
    public static void main(String[] args) {
        int x = Integer.parseInt(args[0]);
        int y = Integer.parseInt(args[1]);
        int z = Integer.parseInt(args[2]);
        if (x < 0 || y < 0 || z < 0) {
            System.out.println(false);
            return;
        }
        boolean isRight;
        if (x > y && x > z) {
            isRight = pythagorean(y, z, x);
        } else if (y > x && y > z) {
            isRight = pythagorean(x, z, y);
        } else {
            isRight = pythagorean(x, y, z);
        }
        System.out.println(isRight);
    }

    private static boolean pythagorean(int a, int b, int c) {
        return a * a + b * b == c * c;
    }
}
