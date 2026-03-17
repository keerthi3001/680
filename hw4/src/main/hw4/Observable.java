// Observable.java
package hw4;
import java.util.ArrayList;
import java.util.List;

public class Observable<T> {
    private final List<Observer<T>> observers = new ArrayList<>();

    public void addObserver(Observer<T> o) { observers.add(o); }
    public void removeObserver(Observer<T> o) { observers.remove(o); }
    public int countObservers() { return observers.size(); }
    public List<Observer<T>> getObservers() { return List.copyOf(observers); }
    public void clearObservers() { observers.clear(); }

    protected void notifyObservers(T event) {
        for (Observer<T> ob : observers) {
            ob.update(this, event);
        }
    }
}
