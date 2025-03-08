public class Clock {
    /**
     * Creates a clock whose initial time is h hours and m minutes.
     */
    public Clock(int h, int m) {}

    /**
     * Creates a clock whose initial time is specified as a string, using the format HH:MM.
     */
    public Clock(String s) {}

    /**
     * Returns a string representation of this clock, using the format HH:MM.
     */
    public String toString() {}

    /**
     * Is the time on this clock earlier than the time on that one?
     */
    public boolean isEarlierThan(Clock that) {}

    /**
     * Adds 1 minute to the time on this clock.
     */
    public void tic() {}

    /**
     * Adds delta minutes to the time on this clock.
     */
    public void toc(int delta) {}

    /**
     * Test client.
     */
    public static void main(String[] args) {}
}
