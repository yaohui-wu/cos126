/**
 * Represents time on a MAX_HOURS-hour clock with the HH:MM format. Time is measured
 * in hours (00–23) and minutes (00–59).
 * 
 * @author Yaohui Wu
 */
public class Clock {
    private static final int HOUR_LIMIT = 24;
    private static final int MINUTES_LIMIT = 60;
    private int hours;
    private int minutes;

    /**
     * Creates a clock whose initial time is h hours and m minutes.
     */
    public Clock(int h, int m) {
        validateHours(h);
        validateMinutes(m);
        hours = h;
        minutes = m;
    }

    /**
     * Creates a clock whose initial time is specified as a string, using the
     * format HH:MM.
     */
    public Clock(String s) {
        validateStr(s);
        int h = Integer.parseInt(s.substring(0, 2));
        validateHours(h);
        int m = Integer.parseInt(s.substring(3, 5));
        validateMinutes(m);
        hours = h;
        minutes = m;
    }

    private void validateHours(int h) {
        if (h < 0 || h >= HOUR_LIMIT) {
            String error = "Hours must be between 0 and 23";
            throw new IllegalArgumentException(error);
        }
    }

    private void validateMinutes(int m) {
        if (m < 0 || m >= MINUTES_LIMIT) {
            String error = "Minutes must be between 0 and 59";
            throw new IllegalArgumentException(error);
        }
    }

    private void validateStr(String s) {
        if (s == null || s.length() != 5 || s.charAt(2) != ':') {
            String error = "Invalid time format";
            throw new IllegalArgumentException(error);
        }
    }

    /**
     * Returns a string representation of this clock, using the format HH:MM.
     */
    public String toString() {
        return String.format("%02d:%02d", hours, minutes);
    }

    /**
     * Is the time on this clock earlier than the time on that one?
     */
    public boolean isEarlierThan(Clock that) {
        int h = that.hours;
        int cmp = compareTime(hours, h);
        if (cmp == 0) {
            int m = that.minutes;
            cmp = compareTime(minutes, m);
        }
        return cmp < 0;

    }

    private int compareTime(int t1, int t2) {
        if (t1 < t2) {
            return -1;
        } else if (t1 > t2) {
            return 1;
        }
        return 0;
    }

    /**
     * Adds 1 minute to the time on this clock.
     */
    public void tic() {
        minutes += 1;
        if (minutes >= MINUTES_LIMIT) {
            minutes = 0;
            hours += 1;
            if (hours >= HOUR_LIMIT) {
                hours = 0;
            }
        }
    }

    /**
     * Adds delta minutes to the time on this clock.
     */
    public void toc(int delta) {
        validateDelta(delta);
        int h = delta / MINUTES_LIMIT;
        int m = delta % MINUTES_LIMIT;
        hours += h;
        minutes += m;
        if (minutes >= MINUTES_LIMIT) {
            minutes %= MINUTES_LIMIT;
            hours += 1;
        }
        if (hours >= HOUR_LIMIT) {
            hours %= HOUR_LIMIT;
        }
    }

    private void validateDelta(int delta) {
        if (delta < 0) {
            String error = "Delta must be nonnegative";
            throw new IllegalArgumentException(error);
        }
    }

    /**
     * Test client.
     */
    public static void main(String[] args) {
        Clock c1 = new Clock(23, 59);
        Clock c2 = new Clock("23:59");
        System.out.println(c1);
        System.out.println(c2);
        System.out.println(c1.isEarlierThan(c2));
        c1.tic();
        System.out.println(c1);
        c1.toc(2);
        System.out.println(c1);
    }
}
