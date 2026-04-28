package cs680.hw15;

import java.util.LinkedList;
import java.util.List;

public class Observable<T> {

    private List<Observer<T>> observers = new LinkedList<>();

    public void addObserver(Observer<T> observer) {
        observers.add(observer);
    }

    public void removeObserver(Observer<T> observer) {
        observers.remove(observer);
    }

    public void clearObservers() {
        observers.clear();
    }

    protected void notifyObservers(T event) {
        for (Observer<T> obs : observers) {
            obs.update(event);
        }
    }
}
