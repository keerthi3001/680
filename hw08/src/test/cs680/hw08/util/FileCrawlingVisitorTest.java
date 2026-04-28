package umbcs680.hw08.util;

import umbcs680.hw08.fs.Directory;
import umbcs680.hw08.fs.TestFixtureInitializer;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import java.util.LinkedList;

public class FileCrawlingVisitorTest {

    @Test
    public void verifyFileCrawlingVisitor() {

        TestFixtureInitializer fixture = new TestFixtureInitializer();
        Directory root = fixture.create();

        FileCrawlingVisitor v = new FileCrawlingVisitor();
        root.accept(v);

        LinkedList<String> paths = v.getAbsolutePaths();

        assertEquals(4, paths.size());

        assertTrue(paths.contains("/cs680/readme.md"));
        assertTrue(paths.contains("/cs680/hw01/build.xml"));
        assertTrue(paths.contains("/cs680/hw01/src/A.java"));
        assertTrue(paths.contains("/cs680/hw01/src/B.java"));
    }
}
