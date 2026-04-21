package cs680.hw09;

public class Color {

    private final int redScale;
    private final int greenScale;
    private final int blueScale;

    public Color(int r, int g, int b) {
        this.redScale = clamp(r);
        this.greenScale = clamp(g);
        this.blueScale = clamp(b);
    }

    private int clamp(int v) {
        if (v < 0) return 0;
        if (v > 255) return 255;
        return v;
    }

    public int getRedScale() {
        return redScale;
    }

    public int getGreenScale() {
        return greenScale;
    }

    public int getBlueScale() {
        return blueScale;
    }
}
