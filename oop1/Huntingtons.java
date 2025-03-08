public class Huntingtons {
    /**
     * Returns the maximum number of consecutive repeats of CAG in the DNA
     * string.
     */
    public static int maxRepeats(String dna) {
        int length = dna.length();
        if (length < 3) {
            return 0;
        }
        int max = 0;
        int count = 0;
        int i = 0;
        while (i < length - 2) {
            int j = i + 3;
            String s = dna.substring(i, j);
            if (s.equals("CAG")) {
                count += 1;
                if (count > max) {
                    max = count;
                }
                i = j;
            } else {
                count = 0;
                i += 1;
            }
        }
        return max;
    }

    /**
     * Returns a copy of s, with all whitespace (spaces, tabs, and newlines)
     * removed.
     */
    public static String removeWhitespace(String s) {
        String str = s.replace(" ", "");
        str = str.replace("\t", "");
        str = str.replace("\n", "");
        return str;
    }

    /**
     * Returns one of these diagnoses corresponding to the maximum number of
     * repeats: "not human", "normal", "high risk", or "Huntington's".
     */
    public static String diagnose(int maxRepeats) {
        String diagnose = null;
        if (between(maxRepeats, 40, 180)) {
            diagnose = "Huntington's";
        } else if (between(maxRepeats, 10, 35)) {
            diagnose = "normal";
        } else if (between(maxRepeats, 36, 39)) {
            diagnose = "high risk";
        } else {
            diagnose = "not human";
        }
        return diagnose;
    }

    private static boolean between(int n, int a, int b) {
        return n >= a && n <= b;
    }

    /**
     * Output client.
     */
    public static void main(String[] args) {
        In input = new In(args[0]);
        String dna = input.readAll();
        dna = removeWhitespace(dna);
        int repeats = maxRepeats(dna);
        String diagnose = diagnose(repeats);
        StdOut.printf("max repeats = %d\n", repeats);
        StdOut.println(diagnose);
    }
}
