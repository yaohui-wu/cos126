import java.util.Arrays;

/**
 * A bar aggregates related information (name, value, and category) for use in
 * a bar chart.
 * 
 * @author Yaohui Wu
 */
public final class Bar implements Comparable<Bar> {
    private final String name;
    private final int value;
    private final String category;

    /**
     * Creates a new bar.
     */
    public Bar(String name, int value, String category) {
        validateName(name);
        validateValue(value);
        validateCategory(category);
        this.name = name;
        this.value = value;
        this.category = category;
    }

    private void validateName(String barName) {
        if (barName == null) {
            String error = "Name cannot be null";
            throw new IllegalArgumentException(error);
        }
    }

    private void validateValue(int barValue) {
        if (barValue < 0) {
            String error = "Value cannot be negative";
            throw new IllegalArgumentException(error);
        }
    }

    private void validateCategory(String barCategory) {
        if (barCategory == null) {
            String error = "Category cannot be null";
            throw new IllegalArgumentException(error);
        }
    }

    /**
     * Returns the name of this bar.
     */
    public String getName() {
        return name;
    }

    /**
     * Returns the value of this bar.
     */
    public int getValue() {
        return value;
    }

    /**
     * Returns the category of this bar.
     */
    public String getCategory() {
        return category;
    }

    /**
     * Compare two bars by value.
     */
    public int compareTo(Bar that) {
        validateArg(that);
        if (value < that.value) {
            return -1;
        } else if (value > that.value) {
            return 1;
        }
        return 0;
    }

    private void validateArg(Object that) {
        if (that == null) {
            String error = "Argument cannot be null";
            throw new NullPointerException(error);
        }
    }

    /**
     * Sample client.
     */
    public static void main(String[] args) {
        // create an array of 10 bars
        Bar[] bars = new Bar[10];
        bars[0] = new Bar("Beijing",     22674, "East Asia");
        bars[1] = new Bar("Cairo",       19850, "Middle East");
        bars[2] = new Bar("Delhi",       27890, "South Asia");
        bars[3] = new Bar("Dhaka",       19633, "South Asia");
        bars[4] = new Bar("Mexico City", 21520, "Latin America");
        bars[5] = new Bar("Mumbai",      22120, "South Asia");
        bars[6] = new Bar("Osaka",       20409, "East Asia");
        bars[7] = new Bar("São Paulo",   21698, "Latin America");
        bars[8] = new Bar("Shanghai",    25779, "East Asia");
        bars[9] = new Bar("Tokyo",       38194, "East Asia");

        // sort in ascending order by weight
        Arrays.sort(bars);

        int length = bars.length;
        for (int i = 0; i < length; i++) {
            Bar bar = bars[i];
            String name = bar.getName();
            int value = bar.getValue();
            String category = bar.getCategory();
            String format = "Name: %s, Value: %d, Category: %s\n";
            StdOut.printf(format, name, value, category);
        }
    }
}
