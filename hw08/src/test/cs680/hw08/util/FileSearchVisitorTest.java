package umbcs680.hw08.util;

import umbcs680.hw08.fs.Directory;
import umbcs680.hw08.fs.TestFixtureInitializer;
import org.junit.jupiter.api.Test;

public class FileSearchVisitorTest {

    @Test
    public void runsSearchWithoutError() {
        Directory root = new TestFixtureInitializer().create();

        // Adapt this constructor if your FileSearchVisitor uses a different signature
        FileSearchVisitor v = new FileSearchVisitor("todo.md");

        root.accept(v);
        // No assertions here – we just verify the search visitor can run without throwing exceptions.
    }
}
