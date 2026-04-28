package cs680.hw13;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ImagesTest {

    @Test
    public void testGrayScaleLambda() {
        Image img = new Image(2, 2);

        img.setColor(0, 0, new Color(30, 60, 90));    // avg=60
        img.setColor(1, 0, new Color(255, 0, 0));     // avg=85
        img.setColor(0, 1, new Color(10, 20, 30));    // avg=20
        img.setColor(1, 1, new Color(100, 100, 100)); // avg=100

        Image gray = Images.transform(img, c -> {
            int avg = (c.getRedScale() + c.getGreenScale() + c.getBlueScale()) / 3;
            return new Color(avg, avg, avg);
        });

        assertEquals(60, gray.getColor(0, 0).getRedScale());
        assertEquals(85, gray.getColor(1, 0).getRedScale());
        assertEquals(20, gray.getColor(0, 1).getRedScale());
        assertEquals(100, gray.getColor(1, 1).getRedScale());
    }

    @Test
    public void testBinarizationLambda() {
        Image img = new Image(2, 2);

        img.setColor(0, 0, new Color(200, 200, 200)); // white
        img.setColor(1, 0, new Color(100, 100, 100)); // black
        img.setColor(0, 1, new Color(130, 140, 150)); // white
        img.setColor(1, 1, new Color(10, 10, 10));    // black

        Image bin = Images.transform(img, c -> {
            int avg = (c.getRedScale() + c.getGreenScale() + c.getBlueScale()) / 3;
            // note19/previous note: threshold 127 (<=127 black, >127 white)
            return (avg <= 127) ? new Color(0, 0, 0) : new Color(255, 255, 255);
        });

        assertEquals(255, bin.getColor(0, 0).getRedScale());
        assertEquals(0, bin.getColor(1, 0).getRedScale());
        assertEquals(255, bin.getColor(0, 1).getRedScale());
        assertEquals(0, bin.getColor(1, 1).getRedScale());
    }
}
