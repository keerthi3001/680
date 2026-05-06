package cs680.hw16.fs;

import org.junit.jupiter.api.Test;
import java.util.LinkedList;
import static org.junit.jupiter.api.Assertions.*;

public class SortingTest {

    @Test
    public void testAlphabeticalSort() {

        FileSystem fs = TestFixtureInitializer.createFS();
        Directory src = fs.getRootDirs().getFirst()
                          .getSubDirectories().getFirst()
                          .getSubDirectories().getFirst();

        LinkedList<File> files =
            src.getFiles((a,b) -> a.getName().compareTo(b.getName()));

        assertEquals("A.java", files.get(0).getName());
        assertEquals("B.java", files.get(1).getName());
        assertEquals("C.java", files.get(2).getName());
    }
}
