package cs680.hw14.fs;

import org.junit.jupiter.api.Test;

import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.*;

public class SortingTest {

    @Test
    public void testGetFilesSortedByNameAsc_LE() {
        FileSystem fs = TestFixtureInitializer.createFS();
        Directory src = fs.getRootDirs().getFirst()
                .getSubDirectories().getFirst()
                .getSubDirectories().getFirst();

        LinkedList<File> files = src.getFiles(
                (a, b) -> a.getName().compareToIgnoreCase(b.getName())
        );

        assertEquals("A.java", files.get(0).getName());
        assertEquals("B.java", files.get(1).getName());
        assertEquals("C.java", files.get(2).getName());
    }

    @Test
    public void testGetFilesSortedBySizeAsc_LE() {
        FileSystem fs = TestFixtureInitializer.createFS();
        Directory src = fs.getRootDirs().getFirst()
                .getSubDirectories().getFirst()
                .getSubDirectories().getFirst();

        LinkedList<File> files = src.getFiles(
                (a, b) -> Integer.compare(a.getSize(), b.getSize())
        );

        // sizes: C=50, A=100, B=200
        assertEquals("C.java", files.get(0).getName());
        assertEquals("A.java", files.get(1).getName());
        assertEquals("B.java", files.get(2).getName());
    }

    @Test
    public void testGetSubDirectoriesSortedByNameDesc_LE() {
        FileSystem fs = TestFixtureInitializer.createFS();
        Directory src = fs.getRootDirs().getFirst()
                .getSubDirectories().getFirst()
                .getSubDirectories().getFirst();

        LinkedList<Directory> dirs = src.getSubDirectories(
                (a, b) -> b.getName().compareToIgnoreCase(a.getName())
        );

        // dirs are: docs, bin => name desc: docs then bin
        assertEquals("docs", dirs.get(0).getName());
        assertEquals("bin", dirs.get(1).getName());
    }

    @Test
    public void testGetLinksSortedByNameAsc_LE() {
        FileSystem fs = TestFixtureInitializer.createFS();
        Directory src = fs.getRootDirs().getFirst()
                .getSubDirectories().getFirst()
                .getSubDirectories().getFirst();

        LinkedList<Link> links = src.getLinks(
                (a, b) -> a.getName().compareToIgnoreCase(b.getName())
        );

        assertEquals(1, links.size());
        assertEquals("linkToDocs", links.get(0).getName());
        assertEquals("docs", links.get(0).getTarget().getName());
    }
}
