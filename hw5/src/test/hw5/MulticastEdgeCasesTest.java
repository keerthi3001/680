package hw5;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MulticastEdgeCasesTest {

    @Test
    void unsubscribe_stops_future_notifications() {
        LaundryController c = new LaundryController(2, MachineStatus.AVAILABLE, 0.0);
        AnalyticsObserverV2 analytics = new AnalyticsObserverV2();

        c.addStatusObserver(analytics);
        c.changeStatus(MachineStatus.IN_USE);    // counted
        c.removeStatusObserver(analytics);
        c.changeStatus(MachineStatus.FINISHED);  // not counted

        assertEquals(1, analytics.count(MachineStatus.IN_USE));
        assertEquals(0, analytics.count(MachineStatus.FINISHED));
    }

    @Test
    void duplicate_values_do_not_broadcast() {
        LaundryController c = new LaundryController(3, MachineStatus.AVAILABLE, 100.0);
        AnalyticsObserverV2 analytics = new AnalyticsObserverV2();
        c.addEnergyObserver(analytics);

        c.updateWatts(100.0);  // same as initial -> no event
        c.updateWatts(250.0);  // event
        c.updateWatts(250.0);  // duplicate -> no event

        assertEquals(250.0, analytics.avgWatts(), 1e-9);
    }
}
