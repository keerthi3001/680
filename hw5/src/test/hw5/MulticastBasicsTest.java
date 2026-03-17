package hw5;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MulticastBasicsTest {

    @Test
    void status_and_energy_streams_are_independent() {
        LaundryController c = new LaundryController(1, MachineStatus.AVAILABLE, 0.0);

        WallDisplayObserverV2 wall = new WallDisplayObserverV2();
        MobileAppObserverV2 mobile = new MobileAppObserverV2();
        AnalyticsObserverV2 analytics = new AnalyticsObserverV2();

        // Subscriptions: wall -> status only, mobile -> both, analytics -> both
        c.addStatusObserver(wall);
        c.addStatusObserver(mobile);
        c.addStatusObserver(analytics);
        c.addEnergyObserver(mobile);
        c.addEnergyObserver(analytics);

        // Events
        c.changeStatus(MachineStatus.IN_USE);    // status listeners
        c.updateWatts(450.0);                    // energy listeners
        c.changeStatus(MachineStatus.FINISHED);  // status listeners

        assertEquals(1, analytics.count(MachineStatus.IN_USE));
        assertEquals(1, analytics.count(MachineStatus.FINISHED));
        assertTrue(analytics.avgWatts() > 0.0);
    }
}
