// LaundryMachineObservable.java
package hw4;

public class LaundryMachineObservable extends Observable<LaundryEvent> {
    private final int machineId;
    private MachineStatus status;

    public LaundryMachineObservable(int machineId, MachineStatus initial) {
        this.machineId = machineId;
        this.status = initial;
    }
    public int getMachineId() { return machineId; }
    public MachineStatus getStatus() { return status; }

    public void changeStatus(MachineStatus newStatus) {
        this.status = newStatus;
        notifyObservers(new LaundryEvent(machineId, newStatus));
    }
}
