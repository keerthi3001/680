package hw5;

public final class StatusEvent {
    private final int machineId;
    private final MachineStatus status;

    public StatusEvent(int machineId, MachineStatus status){
        this.machineId = machineId;
        this.status = status;
    }

    public int getMachineId(){ return machineId; }
    public MachineStatus getStatus(){ return status; }
}
