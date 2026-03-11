package hw5;

public final class EnergyEvent {
    private final int machineId;
    private final double watts;

    public EnergyEvent(int machineId, double watts){
        this.machineId = machineId;
        this.watts = watts;
    }

    public int getMachineId(){ return machineId; }
    public double getWatts(){ return watts; }
}
