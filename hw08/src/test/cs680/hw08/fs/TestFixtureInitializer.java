package umbcs680.hw08.fs;

import java.time.LocalDateTime;
import org.junit.jupiter.api.BeforeEach;

public class TestFixtureInitializer {

    protected FileSystem fs;

    protected Directory cs680;
    protected Directory hw01;
    protected Directory src;

    protected File aJava;
    protected File bJava;
    protected File buildXml;
    protected File readme;

    protected Link rm;

    // IMPORTANT: This runs before EACH test
    @BeforeEach
    public void setUp() {
        create();
    }

    public Directory create() {
        fs = FileSystem.getFileSystem();
        fs.clearRootDirs();

        LocalDateTime t = LocalDateTime.of(2024, 11, 1, 12, 0);

        cs680 = new Directory(null, "cs680", t);
        fs.appendRootDir(cs680);

        hw01 = new Directory(cs680, "hw01", t.plusMinutes(1));
        src  = new Directory(hw01, "src", t.plusMinutes(2));

        aJava = new File(src, "A.java", 80, t.plusMinutes(3));
        bJava = new File(src, "B.java", 90, t.plusMinutes(4));

        buildXml = new File(hw01, "build.xml", 60, t.plusMinutes(5));
        readme   = new File(cs680, "readme.md", 120, t.plusMinutes(6));

        rm = new Link(hw01, "rm.md", readme, t.plusMinutes(7));

        return cs680;
    }
}
