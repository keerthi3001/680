package cs680.hw15;

import java.time.LocalDateTime;

public class LaundryEvent {

    private String machineName;
    private String status;
    private LocalDateTime time;

    public LaundryEvent(String machineName, String status) {
        this.machineName = machineName;
        this.status = status;
        this.time = LocalDateTime.now();
    }

    public String getMachineName() {
        return machineName;
    }

    public String getStatus() {
        return status;
    }

    public LocalDateTime getTime() {
        return time;
    }
}
