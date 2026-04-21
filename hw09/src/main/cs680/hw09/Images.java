package cs680.hw09;

public class Images {

    private Images() {
        // utility class, no instances
    }

    public static Image transform(Image image, ColorAdjuster adjuster) {
        if (image == null) {
            throw new NullPointerException("image is null");
        }
        if (adjuster == null) {
            throw new NullPointerException("adjuster is null");
        }

        Image result = new Image(image.getHeight(), image.getWidth());

        for (int y = 0; y < image.getHeight(); y++) {
            for (int x = 0; x < image.getWidth(); x++) {
                Color original = image.getColor(x, y);
                Color modified = adjuster.adjust(original);
                result.setColor(x, y, modified);
            }
        }

        return result;
    }
}
