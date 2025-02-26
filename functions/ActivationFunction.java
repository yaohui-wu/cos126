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
        double tanh = 1.0;
        int cmp = Double.compare(x, 20.0);
        if (cmp >= 0) {
            return tanh;
        }
        cmp = Double.compare(x, -20.0);
        if (cmp <= 0) {
            tanh = -1.0;
            return tanh;
        }
        double posEx = Math.exp(x); // Positive exponent.
        double negEx = Math.exp(-x); // Negative exponent.
        tanh = (posEx - negEx) / (posEx + negEx);
        return tanh;
    }

    /**
     * Returns the softsign function of X.
     */
    public static double softsign(double x) {
        double softsign = 1.0;
        if (x == Double.POSITIVE_INFINITY) {
            return softsign;
        }
        if (x == Double.NEGATIVE_INFINITY) {
            softsign = -1.0;
            return softsign;
        }
        softsign = x / (1.0 + Math.abs(x));
        return softsign;
    }

    /**
     * Returns the square nonlinearity function of X.
     */
    public static double sqnl(double x) {
        double sqnl = -1.0;
        // Compare with the lower endpoint.
        int cmp = Double.compare(x, -2.0);
        if (cmp <= 0) {
            return sqnl;
        }
        // Compare with the upper endpoint.
        cmp = Double.compare(x, 2.0);
        if (cmp >= 0) {
            sqnl = 1.0;
            return sqnl;
        }
        double frac = x * x / 4.0;
        // Compare with the middle point.
        cmp = Double.compare(x, 0.0);
        if (cmp < 0) {
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
