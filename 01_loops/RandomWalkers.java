public class RandomWalkers {
    public static void main(String[] args) {
        int r = Integer.parseInt(args[0]);
        int trials = Integer.parseInt(args[1]);
        double avg = 0; // Average number of steps.
        for (int i = 0; i < trials; i += 1) {
            // Simulate a random walk.
            // Starting point.
            int x = 0;
            int y = 0;
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
                manhattan = Math.abs(x) + Math.abs(y);
            }
            avg += steps;
        }
        avg /= trials;
        System.out.println("average number of steps = " + avg);
    }
}
