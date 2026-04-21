package cs680.hw09;

import java.util.ArrayList;
import java.util.List;

public class Image {

    private final int height;
    private final int width;
    private final List<List<Color>> pixels;

    public Image(int height, int width) {
        if (height <= 0 || width <= 0) {
            throw new IllegalArgumentException("Height and width must be positive");
        }

        this.height = height;
        this.width = width;
        this.pixels = new ArrayList<>();

        for (int y = 0; y < height; y++) {
            List<Color> row = new ArrayList<>();
            for (int x = 0; x < width; x++) {
                row.add(new Color(0, 0, 0));  // default black pixel
            }
            pixels.add(row);
        }
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }

    public Color getColor(int x, int y) {
        checkBounds(x, y);
        return pixels.get(y).get(x);
    }

    public void setColor(int x, int y, Color color) {
        if (color == null) {
            throw new NullPointerException("color is null");
        }
        checkBounds(x, y);
        pixels.get(y).set(x, color);
    }

    private void checkBounds(int x, int y) {
        if (x < 0 || x >= width || y < 0 || y >= height) {
            throw new IndexOutOfBoundsException(
                "Invalid coordinates: (" + x + ", " + y + ")"
            );
        }
    }
}
