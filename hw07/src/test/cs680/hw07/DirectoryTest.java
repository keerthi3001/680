package cs680.hw07;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class DirectoryTest extends TestFixtureInitializer {

    @Test
    public void verifyCountChildren() {
        // cs680 has hw01 + readme
        assertEquals(2, cs680.countChildren());

        // hw01 has src + build.xml + rm.md(link)
        assertEquals(3, hw01.countChildren());

        // src has A.java + B.java
        assertEquals(2, src.countChildren());
    }

    @Test
    public void verifyGetSubDirectories() {
        assertEquals(1, cs680.getSubDirectories().size()); // hw01
        assertEquals(1, hw01.getSubDirectories().size());  // src
        assertEquals(0, src.getSubDirectories().size());
    }

    @Test
    public void verifyGetFiles() {
        assertEquals(1, cs680.getFiles().size());  // readme
        assertEquals(1, hw01.getFiles().size());   // build.xml
        assertEquals(2, src.getFiles().size());    // A.java, B.java
    }

    @Test
    public void verifyGetLinks() {
        // HW7 expects Directory to return links
        assertEquals(0, cs680.getLinks().size());
        assertEquals(1, hw01.getLinks().size()); // rm.md
        assertEquals(0, src.getLinks().size());
        assertSame(rm, hw01.getLinks().get(0));
    }

    @Test
    public void verifyTotalSize() {
        // link size is 0
        assertEquals(120 + 60 + 80 + 90, cs680.getTotalSize());
        assertEquals(60 + 80 + 90, hw01.getTotalSize());
        assertEquals(80 + 90, src.getTotalSize());
    }
}
