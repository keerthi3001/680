package cs680.hw09;

public class GrayScaleAdjuster implements ColorAdjuster {

    @Override
    public Color adjust(Color color) {
        if (color == null) {
            throw new NullPointerException("color is null");
        }

        int r = color.getRedScale();
        int g = color.getGreenScale();
        int b = color.getBlueScale();
        int avg = (r + g + b) / 3;

        return new Color(avg, avg, avg);
    }
}
