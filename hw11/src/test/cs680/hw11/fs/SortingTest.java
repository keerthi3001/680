import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.*;

import cs680.hw11.fs.FileSystem;
import cs680.hw11.fs.Directory;
import cs680.hw11.fs.File;
import cs680.hw11.fs.AlphabeticalComparator;
import cs680.hw11.fs.ReverseAlphabeticalComparator;
import cs680.hw11.fs.SizeComparator;
import cs680.hw11.fs.TimeStampComparator;

public class SortingTest {

    private FileSystem fs;
    private Directory rootDir;
    private Directory hw11;
    private Directory src;

    @BeforeEach
    public void setUp() {
        fs = TestFixtureInitializer.createSampleFS();
        rootDir = fs.getRootDirs().getFirst();
        hw11 = rootDir.getSubDirectories().getFirst();
        src  = hw11.getSubDirectories().getFirst();
    }

    @Test
    public void testFilesAlphabeticalOrder() {
        LinkedList<File> filesNatural = src.getFiles(); // default
        LinkedList<File> filesWithComparator =
                src.getFiles(new AlphabeticalComparator());

        assertEquals("A.java", filesNatural.get(0).getName());
        assertEquals("B.java", filesNatural.get(1).getName());
        assertEquals(filesNatural, filesWithComparator);
    }

    @Test
    public void testFilesReverseAlphabeticalOrder() {
        LinkedList<File> files =
                src.getFiles(new ReverseAlphabeticalComparator());

        assertEquals("B.java", files.get(0).getName());
        assertEquals("A.java", files.get(1).getName());
    }

    @Test
    public void testFilesSizeOrder() {
        LinkedList<File> files = src.getFiles(new SizeComparator());

        
        assertEquals("A.java", files.get(0).getName());
        assertEquals("B.java", files.get(1).getName());
    }

    @Test
    public void testFilesTimeStampOrder() {
        LinkedList<File> files = src.getFiles(new TimeStampComparator());

    
        assertEquals("A.java", files.get(0).getName());
        assertEquals("B.java", files.get(1).getName());
    }
}
