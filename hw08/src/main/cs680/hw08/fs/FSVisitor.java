package umbcs680.hw08.fs;

public interface FSVisitor {
    void visit(Directory dir);
    void visit(File file);
    void visit(Link link);
}
