public class CMYKtoRGB {
    public static void main(String[] args) {
        // converts from CMYK format to RGB format. 
        double cyan = Double.parseDouble(args[0]);
        double magenta = Double.parseDouble(args[1]);
        double yellow = Double.parseDouble(args[2]);
        double black = Double.parseDouble(args[3]);
        double white = 1 - black;
        final int MAX = 255;
        double factor = MAX * white;
        int red = (int) Math.round(factor * (1 - cyan));
        int green = (int) Math.round(factor * (1 - magenta));
        int blue = (int) Math.round(factor * (1 - yellow));
        System.out.println("red   = " + red);
        System.out.println("green = " + green);
        System.out.println("blue  = " + blue);
    }
}
