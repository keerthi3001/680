package hw4;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class LaundryObserverBasicTest {
    @Test
    public void testBasicNotification() {
        LaundryMachineObservable machine = new LaundryMachineObservable(1, MachineStatus.AVAILABLE);
        AnalyticsObserver analytics = new AnalyticsObserver();
        WallDisplayObserver wall = new WallDisplayObserver();

        machine.addObserver(analytics);
        machine.addObserver(wall);

        machine.changeStatus(MachineStatus.IN_USE);
        assertEquals(1, analytics.count(MachineStatus.IN_USE));

        machine.changeStatus(MachineStatus.FINISHED);
        assertEquals(1, analytics.count(MachineStatus.FINISHED));
    }
}
