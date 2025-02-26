public class ActivationFunction {
    /**
     * Returns the Heaviside function of X.
     */
    public static double heaviside(double x) {
        if (Double.isNaN(x)) {
            return Double.NaN;
        }
        double heaviside = 0.0;
        if (x < 0.0) {
            return heaviside;
        } else if (x > 0.0) {
            heaviside = 1.0;
        } else {
            heaviside = 0.5;
        }
        return heaviside;
    }

    /**
     * Returns the sigmoid function of X.
     */
    public static double sigmoid(double x) {
        if (Double.isNaN(x)) {
            return Double.NaN;
        }
        double sigmoid = 1.0 / (1.0 + Math.exp(-x));
        return sigmoid;
    }

    /**
     * Returns the hyperbolic tangent of X.
     */
    public static double tanh(double x) {
        double posEx = Math.exp(x); // Positive exponent.
        double negEx = Math.exp(-x); // Negative exponent.
        double tanh = (posEx - negEx) / (posEx + negEx);
        return tanh;
    }

    /**
     * Returns the softsign function of X.
     */
    public static double softsign(double x) {
        double softsign = x / (1.0 + Math.abs(x));
        return softsign;
    }

    /**
     * Returns the square nonlinearity function of X.
     */
    public static double sqnl(double x) {
        double sqnl = -1.0;
        // Compare with the lower endpoint.
        int cmpLo = Double.compare(x, -2.0);
        if (cmpLo <= 0) {
            return sqnl;
        }
        // Compare with the upper endpoint.
        int cmpHi = Double.compare(x, 2.0);
        if (cmpHi >= 0) {
            sqnl = 1.0;
            return sqnl;
        }
        double frac = x * x / 4.0;
        // Compare with the middle point.
        int cmpMid = Double.compare(x, 0.0);
        if (cmpMid < 0) {
            sqnl = x + frac;
            return sqnl;
        }
        sqnl = x - frac;
        return sqnl;
    }

    /**
     * Takes a double command-line argument X and prints each activation
     * function evaluated at X.
     */
    public static void main(String[] args) {
        double x = Double.parseDouble(args[0]);
        System.out.println("heaviside(" + x + ") = " + heaviside(x));
        System.out.println("sigmoid(" + x + ") = " + sigmoid(x));
        System.out.println("tanh(" + x + ") = " + tanh(x));
        System.out.println("softsign(" + x + ") = " + softsign(x));
        System.out.println("sqnl(" + x + ") = " + sqnl(x));
    }
}
