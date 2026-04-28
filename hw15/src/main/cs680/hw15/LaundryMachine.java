package cs680.hw15;

public class LaundryMachine extends Observable<LaundryEvent> {

    private String name;
    private String status;

    public LaundryMachine(String name) {
        this.name = name;
        this.status = "IDLE";
    }

    public void setStatus(String newStatus) {
        this.status = newStatus;
        notifyObservers(new LaundryEvent(name, newStatus));
    }

    public String getStatus() {
        return status;
    }
}
