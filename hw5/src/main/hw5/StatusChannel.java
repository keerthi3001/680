package hw5;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class StatusChannel {
    private final List<StatusObserver> observers = new ArrayList<>();
    public void subscribe(StatusObserver o){ observers.add(o); }
    public void unsubscribe(StatusObserver o){ observers.remove(o); }
    public int size(){ return observers.size(); }
    public List<StatusObserver> snapshot(){ return Collections.unmodifiableList(observers); }
    public void publish(StatusEvent e){ for (StatusObserver o : observers) o.onStatus(e); }
}
