package hw4;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class LaundryObserverEdgeTest {

    @Test
    void testMultipleMachinesAndObservers() {
        LaundryMachineObservable m1 = new LaundryMachineObservable(101, MachineStatus.AVAILABLE);
        LaundryMachineObservable m2 = new LaundryMachineObservable(102, MachineStatus.AVAILABLE);

        MobileNotifierObserver mobile = new MobileNotifierObserver();
        AnalyticsObserver analytics = new AnalyticsObserver();

        // subscribe: mobile only to m1, analytics only to m2
        m1.addObserver(mobile);
        m2.addObserver(analytics);

        // generate events
        m1.changeStatus(MachineStatus.IN_USE);     // only mobile sees this
        m1.changeStatus(MachineStatus.FINISHED);   // only mobile sees this
        m2.changeStatus(MachineStatus.IN_USE);     // analytics sees this

        // analytics only saw exactly one event: m2 -> IN_USE
        assertEquals(1, analytics.count(MachineStatus.IN_USE));
        assertEquals(0, analytics.count(MachineStatus.AVAILABLE));
        assertEquals(0, analytics.count(MachineStatus.FINISHED));
    }
}
