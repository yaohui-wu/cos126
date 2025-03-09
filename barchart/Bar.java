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
        this.name = name;
        this.value = value;
        this.category = category;
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
    public int compareTo(Bar that) {}

    /**
     * Sample client.
     */
    public static void main(String[] args) {}
}
