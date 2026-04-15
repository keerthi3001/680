package cs680.hw07;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class FileSystemTest extends TestFixtureInitializer {

    @Test
    public void verifySingleton() {
        FileSystem fs1 = FileSystem.getFileSystem();
        FileSystem fs2 = FileSystem.getFileSystem();
        assertSame(fs1, fs2);
    }

    @Test
    public void verifyRootDirs() {
        assertEquals(1, fs.getRootDirs().size());
        assertSame(cs680, fs.getRootDirs().get(0));
    }
}
