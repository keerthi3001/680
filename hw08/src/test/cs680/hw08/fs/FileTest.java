package umbcs680.hw08.fs;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

// Simple tests for the File class in the file system.
public class FileTest {

    @Test
    public void fileHasCorrectBasicProperties() {
        LocalDateTime now = LocalDateTime.now();

        // Directory(parent, name, createdTime)
        Directory root = new Directory(null, "root", now);

        // File(parent, name, size, createdTime)
        File f = new File(root, "file.txt", 100, now);

        // Basic checks
        assertNotNull(f, "File object should not be null");
        assertEquals("file.txt", f.getName(), "File name should match");
        assertEquals(100, f.getSize(), "File size should match");
        assertEquals(root, f.getParent(), "Parent directory should be root");
        assertFalse(f.isDirectory(), "File should not be a directory");
    }
}
