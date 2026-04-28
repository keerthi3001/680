package cs680.hw13;

import java.util.ArrayList;
import java.util.List;

public class Image {
    private final int height;
    private final int width;
    private final List<List<Color>> pixels;

    /** Lecture note API: Image(height, width). */
    public Image(int height, int width) {
        if (height <= 0 || width <= 0) {
            throw new IllegalArgumentException("height and width must be positive");
        }
        this.width = width;
        this.height = height;
        this.pixels = new ArrayList<>();

        for (int y = 0; y < height; y++) {
            pixels.add(new ArrayList<>());
            for (int x = 0; x < width; x++) {
                pixels.get(y).add(new Color(0, 0, 0));
            }
        }
    }

    public int getWidth() { return width; }
    public int getHeight() { return height; }

    public Color getColor(int x, int y) {
        checkBounds(x, y);
        return pixels.get(y).get(x);
    }

    public void setColor(int x, int y, Color c) {
        if (c == null) throw new NullPointerException("color is null");
        checkBounds(x, y);
        pixels.get(y).set(x, c);
    }

    private void checkBounds(int x, int y) {
        if (x < 0 || x >= width || y < 0 || y >= height) {
            throw new IndexOutOfBoundsException("Invalid coordinates: (" + x + ", " + y + ")");
        }
    }
}
