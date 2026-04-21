package cs680.hw09;

public class BinarizationAdjuster implements ColorAdjuster {

    private final int threshold;

    public BinarizationAdjuster() {
        this(127); // default per lecture note
    }

    public BinarizationAdjuster(int threshold) {
        if (threshold < 0 || threshold > 255) {
            throw new IllegalArgumentException("threshold must be in [0,255]");
        }
        this.threshold = threshold;
    }

    @Override
    public Color adjust(Color color) {
        if (color == null) {
            throw new NullPointerException("color is null");
        }

        int avg = (color.getRedScale()
                 + color.getGreenScale()
                 + color.getBlueScale()) / 3;

        if (avg <= threshold) {
            return new Color(0, 0, 0);       // black
        } else {
            return new Color(255, 255, 255); // white
        }
    }
}
