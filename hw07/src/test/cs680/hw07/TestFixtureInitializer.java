package cs680.hw07;

import org.junit.jupiter.api.BeforeAll;
import java.time.LocalDateTime;

public class TestFixtureInitializer {

    protected static FileSystem fs;

    // same tree as HW6 (Lecture Note 11)
    protected static Directory cs680;
    protected static Directory hw01;
    protected static Directory src;

    protected static File aJava;
    protected static File bJava;
    protected static File buildXml;
    protected static File readme;

    // HW7 adds a link
    protected static Link rm;

    @BeforeAll
    public static void setUpFileSystem() {

        fs = FileSystem.getFileSystem();
        fs.clearRootDirs();   // IMPORTANT: singleton reset

        LocalDateTime t = LocalDateTime.of(2024, 11, 1, 12, 0);

        // root dir
        cs680 = new Directory(null, "cs680", t);
        fs.appendRootDir(cs680);

        // hw01 and src directories
        hw01 = new Directory(cs680, "hw01", t.plusMinutes(1));
        src  = new Directory(hw01, "src", t.plusMinutes(2));

        // files inside src
        aJava = new File(src, "A.java", 80, t.plusMinutes(3));
        bJava = new File(src, "B.java", 90, t.plusMinutes(4));

        // file inside hw01
        buildXml = new File(hw01, "build.xml", 60, t.plusMinutes(5));

        // file inside cs680
        readme = new File(cs680, "readme.md", 120, t.plusMinutes(6));

        // link inside hw01 targeting readme
        // NOTE: If your Link constructor has no size param, tell me.
        rm = new Link(hw01, "rm.md", t.plusMinutes(7), readme);
    }
}
