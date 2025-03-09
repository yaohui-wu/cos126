import java.util.Arrays;
import java.util.Collections;

public class BarChartRacer {
    public static void main(String[] args) {
        StdAudio.playInBackground("soundtrackE.wav");
        In file = new In(args[0]);
        int k = Integer.parseInt(args[1]);
        String title = file.readLine();
        String xAxisLabel = file.readLine();
        String dataSource = file.readLine();
        BarChart chart = new BarChart(title, xAxisLabel, dataSource);
        StdDraw.setCanvasSize(1000, 700);
        StdDraw.enableDoubleBuffering();
        while (file.hasNextLine()) {
            file.readLine(); // Skip the blank line.
            // Number of records in group.
            int n = Integer.parseInt(file.readLine());
            String caption = null;
            Bar[] bars = new Bar[n];
            for (int i = 0; i < n; i++) {
                String line = file.readLine(); // Record.
                String[] fields = line.split(",");
                if (caption == null) {
                    caption = fields[0];
                }
                String name = fields[1];
                int value = Integer.parseInt(fields[3]);
                String category = fields[4];
                Bar bar = new Bar(name, value, category);
                bars[i] = bar;
            }
            Arrays.sort(bars, Collections.reverseOrder());
            chart.setCaption(caption);
            for (int i = 0; i < k; i++) {
                Bar bar = bars[i];
                String name = bar.getName();
                int value = bar.getValue();
                String category = bar.getCategory();
                if (value > 0) {
                    chart.add(name, value, category);
                }
            }
            chart.draw();
            StdDraw.show();
            StdDraw.pause(50);
            StdDraw.clear();
            chart.reset();
        }
    }
}
