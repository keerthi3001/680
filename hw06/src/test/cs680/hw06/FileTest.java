package cs680.hw06;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class FileTest extends TestFixtureInitializer {

    @Test
    public void verifyFileNameAndSize() {
        assertEquals("A.java", aJava.getName());
        assertEquals(80, aJava.getSize());
    }

    @Test
    public void verifyFileIsNotDirectory() {
        assertFalse(aJava.isDirectory());
    }
}
