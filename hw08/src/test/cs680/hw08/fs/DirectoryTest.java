package umbcs680.hw08.fs;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class DirectoryTest extends TestFixtureInitializer {

    @Test
    public void verifyCountsAndCollections() {
        assertEquals(2, cs680.countChildren()); // hw01 + readme
        assertEquals(3, hw01.countChildren());  // src + build.xml + rm link
        assertEquals(2, src.countChildren());   // A.java + B.java

        assertEquals(1, cs680.getSubDirectories().size());
        assertEquals(1, hw01.getSubDirectories().size());
        assertEquals(0, src.getSubDirectories().size());

        assertEquals(1, cs680.getFiles().size()); // readme
        assertEquals(1, hw01.getFiles().size());  // build.xml
        assertEquals(2, src.getFiles().size());   // A.java, B.java

        assertEquals(0, cs680.getLinks().size());
        assertEquals(1, hw01.getLinks().size());
        assertEquals(0, src.getLinks().size());
    }

    @Test
    public void verifyTotalSize() {
        // links have size 0
        assertEquals(120 + 60 + 80 + 90, cs680.getTotalSize());
        assertEquals(60 + 80 + 90, hw01.getTotalSize());
        assertEquals(80 + 90, src.getTotalSize());
    }
}
