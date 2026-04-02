package cs680.hw06;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class DirectoryTest extends TestFixtureInitializer {

    @Test
    public void verifyCountChildren() {
        // umbcs680 has: hw01 + readme.md
        assertEquals(2, cs680.countChildren());

        // hw01 has: src + build.xml
        assertEquals(2, hw01.countChildren());

        // src has: A.java + B.java
        assertEquals(2, src.countChildren());
    }

    @Test
    public void verifyGetSubDirectories() {
        assertEquals(1, cs680.getSubDirectories().size()); 
        assertEquals(1, hw01.getSubDirectories().size());     
        assertEquals(0, src.getSubDirectories().size());     
    }

    @Test
    public void verifyGetFiles() {
        assertEquals(1, cs680.getFiles().size()); 
        assertEquals(1, hw01.getFiles().size());     
        assertEquals(2, src.getFiles().size());      
    }

    @Test
    public void verifyTotalSize() {
    
        assertEquals(120 + 60 + 80 + 90, cs680.getTotalSize());
        assertEquals(60 + 80 + 90, hw01.getTotalSize());
        assertEquals(80 + 90, src.getTotalSize());
    }
}
