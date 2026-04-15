package cs680.hw07;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class LinkTest extends TestFixtureInitializer {

    @Test
    public void verifyLinkNameAndParent() {
        assertEquals("rm.md", rm.getName());
        assertSame(hw01, rm.getParent());
    }

    @Test
    public void verifyLinkIsNotDirectory() {
        assertFalse(rm.isDirectory());
    }

    @Test
    public void verifyLinkTarget() {
        assertSame(readme, rm.getTarget());
        assertEquals("readme.md", rm.getTarget().getName());
    }

    @Test
    public void verifyLinkSizeIsZero() {
        // HW7 slide: size is 0 for directory and link
        assertEquals(0, rm.getSize());
    }
}
