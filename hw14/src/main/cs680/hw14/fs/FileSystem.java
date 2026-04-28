package cs680.hw14.fs;

import java.util.LinkedList;

public class FileSystem {
    private static FileSystem instance = null;
    private LinkedList<Directory> rootDirs = new LinkedList<>();

    private FileSystem() {}

    public static FileSystem getFileSystem() {
        if (instance == null) instance = new FileSystem();
        return instance;
    }

    public LinkedList<Directory> getRootDirs() { return rootDirs; }
    public void appendRootDir(Directory root) { rootDirs.add(root); }
}
