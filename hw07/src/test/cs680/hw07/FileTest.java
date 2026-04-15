package cs680.hw07;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class FileTest extends TestFixtureInitializer {

    @Test
    public void verifyFileBasics() {
        assertEquals("A.java", aJava.getName());
        assertEquals(80, aJava.getSize());
        assertSame(src, aJava.getParent());
        assertFalse(aJava.isDirectory());
    }
}
