package umbcs680.hw08.util;

import umbcs680.hw08.fs.Directory;
import umbcs680.hw08.fs.TestFixtureInitializer;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CountingVisitorTest {

    @Test
    public void countsDirsFilesLinksAndBytes() {
        Directory root = new TestFixtureInitializer().create();
        CountingVisitor v = new CountingVisitor();
        root.accept(v);

        // Fixture structure:
        // dirs: cs680, hw01, src  => 3
        // files: readme, build.xml, A.java, B.java => 4
        // links: rm.md => 1
        // total bytes: 120 + 60 + 80 + 90 => 350
        assertEquals(3, v.getDirNum());
        assertEquals(4, v.getFileNum());
        assertEquals(1, v.getLinkNum());
        assertEquals(350, v.getTotalBytes());
    }

    @Test
    public void countsBytesIncludingLinkTargetWhenEnabled() {
        Directory root = new TestFixtureInitializer().create();
        CountingVisitor v = new CountingVisitor(true);
        root.accept(v);

        // Same counts, but total bytes includes rm.md's target (readme.md = 120) one extra time.
        assertEquals(3, v.getDirNum());
        assertEquals(4, v.getFileNum());
        assertEquals(1, v.getLinkNum());
        assertEquals(470, v.getTotalBytes());
    }
}
