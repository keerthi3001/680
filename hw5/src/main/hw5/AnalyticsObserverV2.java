package hw5;

import java.util.EnumMap;
import java.util.Map;

public class AnalyticsObserverV2 implements StatusObserver, EnergyObserver {
    private final Map<MachineStatus,Integer> statusCounts = new EnumMap<>(MachineStatus.class);
    private double totalWatts = 0.0;
    private int energySamples = 0;

    public AnalyticsObserverV2(){
        for (MachineStatus s : MachineStatus.values()) statusCounts.put(s, 0);
    }

    @Override
    public void onStatus(StatusEvent event) {
        statusCounts.put(event.getStatus(), statusCounts.get(event.getStatus()) + 1);
    }

    @Override
    public void onEnergy(EnergyEvent event) {
        totalWatts += event.getWatts();
        energySamples++;
    }

    public int count(MachineStatus s){ return statusCounts.get(s); }
    public double avgWatts(){ return energySamples == 0 ? 0.0 : totalWatts / energySamples; }
}
