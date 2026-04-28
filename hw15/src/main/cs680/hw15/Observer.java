package cs680.hw15;

@FunctionalInterface
public interface Observer<T> {
    void update(T event);
}
