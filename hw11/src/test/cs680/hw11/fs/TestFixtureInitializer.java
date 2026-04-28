import java.time.LocalDateTime;

import cs680.hw11.fs.Directory;
import cs680.hw11.fs.File;
import cs680.hw11.fs.FileSystem;
import cs680.hw11.fs.Link;

public class TestFixtureInitializer {

    
    public static FileSystem createSampleFS() {
        FileSystem fs = FileSystem.getFileSystem();
        // start from empty
        fs.getRootDirs().clear();

        LocalDateTime now = LocalDateTime.now();

        Directory root = new Directory(null, "cs680", now);
        fs.appendRootDir(root);

        Directory hw11 = new Directory(root, "hw11", now);
        Directory src  = new Directory(hw11, "src", now);

        File aJava  = new File(src, "A.java", 300, now.minusMinutes(5));
        File bJava  = new File(src, "B.java", 400, now.minusMinutes(2));
        File readme = new File(root, "readme.txt", 200, now.minusMinutes(10));

        new Link(hw11, "rm.txt", 0, now, readme);

        return fs;
    }
}
