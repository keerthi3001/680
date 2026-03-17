package hw5;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class EnergyChannel {
    private final List<EnergyObserver> observers = new ArrayList<>();
    public void subscribe(EnergyObserver o){ observers.add(o); }
    public void unsubscribe(EnergyObserver o){ observers.remove(o); }
    public int size(){ return observers.size(); }
    public List<EnergyObserver> snapshot(){ return Collections.unmodifiableList(observers); }
    public void publish(EnergyEvent e){ for (EnergyObserver o : observers) o.onEnergy(e); }
}
