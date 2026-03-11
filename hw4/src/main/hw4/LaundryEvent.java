package hw4;

public class LaundryEvent {
    private final int machineId;
    private final MachineStatus status;

    public LaundryEvent(int machineId, MachineStatus status) {
        this.machineId = machineId;
        this.status = status;
    }

    public int getMachineId() { return machineId; }
    public MachineStatus getStatus() { return status; }
}
