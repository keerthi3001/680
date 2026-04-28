package umbcs680.hw08.util;

import umbcs680.hw08.fs.Directory;
import umbcs680.hw08.fs.TestFixtureInitializer;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class FileSearchVisitorTest {

    @Test
    public void findsExistingFileByName() {
        Directory root = new TestFixtureInitializer().create();

        FileSearchVisitor v = new FileSearchVisitor("readme.md");

        root.accept(v);
        assertEquals(1, v.getFoundFiles().size());
        assertEquals("readme.md", v.getFoundFiles().get(0).getName());
    }

    @Test
    public void returnsEmptyWhenFileDoesNotExist() {
        Directory root = new TestFixtureInitializer().create();

        FileSearchVisitor v = new FileSearchVisitor("does-not-exist.txt");
        root.accept(v);

        assertEquals(0, v.getFoundFiles().size());
    }
}
