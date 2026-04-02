package cs680.hw06;

import java.util.LinkedList;

public class FileSystem {

    private static FileSystem fileSystem = null;
    private LinkedList<Directory> rootDirs;

    private FileSystem() {
        rootDirs = new LinkedList<>();
    }

    public static FileSystem getFileSystem() {
        if (fileSystem == null) {
            fileSystem = new FileSystem();
        }
        return fileSystem;
    }

    public LinkedList<Directory> getRootDirs() {
        return this.rootDirs;
    }

    public void appendRootDir(Directory root) {
        this.rootDirs.add(root);
    }

    public void clearRootDirs() {
        rootDirs.clear();
    }
}
