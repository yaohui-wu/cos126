public class RandomWalker {
    public static void main(String[] args) {
        int r = Integer.parseInt(args[0]);
        // Starting point.
        int x = 0;
        int y = 0;
        System.out.println("(" + x + ", " + y + ")");
        int steps = 0;
        int manhattan = 0; // Manhattan distance.
        while (manhattan != r) {
            double random = Math.random();
            if (random < 0.25) {
                y += 1; // North.
            } else if (random < 0.5) {
                x += 1; // East.
            } else if (random < 0.75) {
                y -= 1; // South.
            } else {
                x -= 1; // West.
            }
            steps += 1;
            System.out.println("(" + x + ", " + y + ")");
            manhattan = Math.abs(x) + Math.abs(y);
        }
        System.out.println("steps = " + steps);
    }
}
