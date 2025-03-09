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

    private void validateName(String name) {
        if (name == null) {
            String error = "Name cannot be null";
            throw new IllegalArgumentException(error);
        }
    }

    private void validateValue(int value) {
        if (value < 0) {
            String error = "Value cannot be negative";
            throw new IllegalArgumentException(error);
        }
    }

    private void validateCategory(String category) {
        if (category == null) {
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
    }

    private void validateArg(Object that) {
        if (that == null) {
            String error = "Argument cannot be null";
            throw new IllegalArgumentException(error);
        }
    }

    /**
     * Sample client.
     */
    public static void main(String[] args) {}
}
