package hw5;

public class LaundryController {
    private final int machineId;
    private MachineStatus status;
    private double watts;

    private final StatusChannel statusBus = new StatusChannel();
    private final EnergyChannel energyBus = new EnergyChannel();

    public LaundryController(int machineId, MachineStatus initial, double initialWatts){
        this.machineId = machineId;
        this.status = initial;
        this.watts = initialWatts;
    }

    // Subscribe APIs
    public void addStatusObserver(StatusObserver o){ statusBus.subscribe(o); }
    public void removeStatusObserver(StatusObserver o){ statusBus.unsubscribe(o); }
    public void addEnergyObserver(EnergyObserver o){ energyBus.subscribe(o); }
    public void removeEnergyObserver(EnergyObserver o){ energyBus.unsubscribe(o); }

    // Getters
    public int getMachineId(){ return machineId; }
    public MachineStatus getStatus(){ return status; }
    public double getWatts(){ return watts; }

    // State changes (with duplicate suppression)
    public void changeStatus(MachineStatus newStatus){
        if (newStatus != this.status){
            this.status = newStatus;
            statusBus.publish(new StatusEvent(machineId, newStatus));
        }
    }

    public void updateWatts(double newWatts){
        if (Double.compare(newWatts, this.watts) != 0){
            this.watts = newWatts;
            energyBus.publish(new EnergyEvent(machineId, newWatts));
        }
    }
}
