package cs680.hw09;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ImagesTest {

    private Image img1x1;
    private Image img1x2;

    @BeforeEach
    public void setUp() {
        img1x1 = new Image(1, 1);
        img1x2 = new Image(1, 2);
    }

    @Test
    public void testGrayScale() {
        img1x1.setColor(0, 0, new Color(100, 150, 200));

        Image gray = Images.transform(img1x1, new GrayScaleAdjuster());
        Color c = gray.getColor(0, 0);

        int expected = (100 + 150 + 200) / 3;
        assertEquals(expected, c.getRedScale());
        assertEquals(expected, c.getGreenScale());
        assertEquals(expected, c.getBlueScale());
    }

    @Test
    public void testBinarization() {
        img1x2.setColor(0, 0, new Color(10, 10, 10));      // dark -> black
        img1x2.setColor(1, 0, new Color(200, 200, 200));   // bright -> white

        Image bin = Images.transform(img1x2, new BinarizationAdjuster());

        assertEquals(0, bin.getColor(0, 0).getRedScale());
        assertEquals(0, bin.getColor(0, 0).getGreenScale());
        assertEquals(0, bin.getColor(0, 0).getBlueScale());

        assertEquals(255, bin.getColor(1, 0).getRedScale());
        assertEquals(255, bin.getColor(1, 0).getGreenScale());
        assertEquals(255, bin.getColor(1, 0).getBlueScale());
    }

    @Test
    public void testOriginalNotChanged() {
        img1x1.setColor(0, 0, new Color(50, 60, 70));

        Images.transform(img1x1, new GrayScaleAdjuster());

        Color original = img1x1.getColor(0, 0);
        assertEquals(50, original.getRedScale());
        assertEquals(60, original.getGreenScale());
        assertEquals(70, original.getBlueScale());
    }
}
