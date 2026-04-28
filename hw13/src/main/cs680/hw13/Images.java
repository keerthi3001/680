package cs680.hw13;

public class Images {

    public static Image transform(Image image, ColorAdjuster adjuster) {
        if (image == null) throw new NullPointerException("image is null");
        if (adjuster == null) throw new NullPointerException("adjuster is null");

        // Lecture note API: Image(height, width)
        Image result = new Image(image.getHeight(), image.getWidth());

        for (int y = 0; y < image.getHeight(); y++) {
            for (int x = 0; x < image.getWidth(); x++) {
                result.setColor(
                    x,
                    y,
                    adjuster.adjust(image.getColor(x, y))
                );
            }
        }
        return result;
    }
}
