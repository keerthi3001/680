package umbcs680.hw08.fs;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class LinkTest extends TestFixtureInitializer {

    @Test
    public void verifyLinkUsesFixture() {
        assertEquals("rm.md", rm.getName());
        assertSame(hw01, rm.getParent());
        assertSame(readme, rm.getTarget());
        assertEquals(0, rm.getSize());
        assertFalse(rm.isDirectory());
    }
}
