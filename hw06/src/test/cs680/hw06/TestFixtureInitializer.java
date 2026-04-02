package cs680.hw06;

import org.junit.jupiter.api.BeforeAll;
import java.time.LocalDateTime;

public class TestFixtureInitializer {

    protected static FileSystem fs;

    protected static Directory cs680;
    protected static Directory hw01;
    protected static Directory src;

    protected static File aJava;
    protected static File bJava;
    protected static File buildXml;
    protected static File readme;

    @BeforeAll
    public static void setUpFileSystem() {
        fs = FileSystem.getFileSystem();
        fs.clearRootDirs();   // IMPORTANT: reset singleton

        LocalDateTime t = LocalDateTime.of(2024, 11, 1, 12, 0);

        cs680 = new Directory(null, "cs680", t);
        fs.appendRootDir(cs680);

        hw01 = new Directory(cs680, "hw01", t.plusMinutes(1));
        src  = new Directory(hw01, "src", t.plusMinutes(2));

        aJava = new File(src, "A.java", 80, t.plusMinutes(3));
        bJava = new File(src, "B.java", 90, t.plusMinutes(4));

        buildXml = new File(hw01, "build.xml", 60, t.plusMinutes(5));
        readme   = new File(cs680, "readme.md", 120, t.plusMinutes(6));
    }
}
