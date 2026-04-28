package cs680.hw11.fs;

import java.util.Comparator;


public class SizeComparator implements Comparator<FSElement> {

    private static int totalSize(FSElement e) {
        if (e instanceof Directory) return ((Directory) e).getTotalSize();
        return e.getSize(); // files: file size; links: typically 0
    }

    @Override
    public int compare(FSElement a, FSElement b) {
        if (a == null && b == null) return 0;
        if (a == null) return -1;
        if (b == null) return 1;

        int sa = totalSize(a);
        int sb = totalSize(b);

        if (sa != sb) {
            return Integer.compare(sa, sb);
        }
        return a.getName().compareToIgnoreCase(b.getName());
    }
}
