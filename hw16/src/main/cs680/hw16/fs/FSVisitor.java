package cs680.hw16.fs;

public interface FSVisitor {
    void visit(Directory dir);
    void visit(File file);
    void visit(Link link);
}
