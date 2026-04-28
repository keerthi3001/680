package cs680.hw14.fs;

import java.time.LocalDateTime;

public class TestFixtureInitializer {

    public static FileSystem createFS() {
        FileSystem fs = FileSystem.getFileSystem();
        fs.getRootDirs().clear();

        // fixed timestamps (deterministic tests)
        LocalDateTime t1 = LocalDateTime.of(2024, 1, 1, 10, 0);
        LocalDateTime t2 = LocalDateTime.of(2024, 1, 2, 10, 0);
        LocalDateTime t3 = LocalDateTime.of(2024, 1, 3, 10, 0);
        LocalDateTime t4 = LocalDateTime.of(2024, 1, 4, 10, 0);

        Directory root = new Directory(null, "root", t1);
        fs.appendRootDir(root);

        Directory hw = new Directory(root, "hw", t2);
        Directory src = new Directory(hw, "src", t3);

        // subdirectories inside src
        Directory docs = new Directory(src, "docs", t4);
        Directory bin = new Directory(src, "bin", t4.minusHours(1));

        // files inside src (different sizes and names)
        new File(src, "A.java", 100, t2);
        new File(src, "B.java", 200, t3);
        new File(src, "C.java", 50,  t4);

        // link inside src
        new Link(src, "linkToDocs", t1.plusHours(2), docs);

        return fs;
    }
}
