package cs680.hw11.fs;


public interface FSVisitor {

    void visit(Directory dir);

    void visit(File file);

    void visit(Link link);
}
