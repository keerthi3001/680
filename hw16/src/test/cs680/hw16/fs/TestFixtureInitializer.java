package cs680.hw16.fs;

import java.time.LocalDateTime;

public class TestFixtureInitializer {

    public static FileSystem createFS() {
        FileSystem fs = FileSystem.getFileSystem();
        fs.getRootDirs().clear();

        Directory root = new Directory(null, "root", LocalDateTime.now());
        fs.appendRootDir(root);

        Directory hw = new Directory(root, "hw", LocalDateTime.now());
        Directory src = new Directory(hw, "src", LocalDateTime.now());

        new File(src, "A.java", 100, LocalDateTime.now());
        new File(src, "B.java", 200, LocalDateTime.now());
        new File(src, "C.java", 50, LocalDateTime.now());

        return fs;
    }
}
