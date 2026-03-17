package hw4;

import java.util.EnumMap;
import java.util.Map;

public class AnalyticsObserver implements Observer<LaundryEvent> {
    private final Map<MachineStatus,Integer> counts = new EnumMap<>(MachineStatus.class);

    public AnalyticsObserver() {
        for (MachineStatus s : MachineStatus.values()) counts.put(s, 0);
    }

    @Override
    public void update(Observable<LaundryEvent> sender, LaundryEvent event) {
        counts.put(event.getStatus(), counts.get(event.getStatus()) + 1);
    }

    public int count(MachineStatus s) { return counts.get(s); }
}
