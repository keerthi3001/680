package cs680.hw11.fs;

import java.util.Comparator;


public class AlphabeticalComparator implements Comparator<FSElement> {

    @Override
    public int compare(FSElement a, FSElement b) {
        if (a == null && b == null) return 0;
        if (a == null) return -1;
        if (b == null) return 1;
        return a.getName().compareToIgnoreCase(b.getName());
    }
}
