package hw03;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ThermostatTest {

    @Test
    void idle_heats_when_below_deadband() {
        Thermostat t = new Thermostat(70.0, 1.0, 60.0, 78.0);
        assertEquals("IDLE", t.currentState());
        t.temperatureMeasured(68.5);  // below (70-1)=69
        assertEquals("HEATING", t.currentState());
        assertTrue(t.isHeating());
        assertFalse(t.isCooling());
    }

    @Test
    void heating_returns_to_idle_at_target() {
        Thermostat t = new Thermostat(70.0, 1.0, 60.0, 78.0);
        t.temperatureMeasured(68.0);  // enter HEATING
        assertEquals("HEATING", t.currentState());
        t.temperatureMeasured(70.0);  // reach target
        assertEquals("IDLE", t.currentState());
        assertFalse(t.isHeating());
        assertFalse(t.isCooling());
    }

    @Test
    void idle_cools_when_above_deadband() {
        Thermostat t = new Thermostat(70.0, 1.0, 60.0, 78.0);
        t.temperatureMeasured(72.5);  // above (70+1)=71
        assertEquals("COOLING", t.currentState());
        assertTrue(t.isCooling());
        assertFalse(t.isHeating());
    }

    @Test
    void away_mode_uses_eco_band() {
        Thermostat t = new Thermostat(70.0, 1.0, 63.0, 77.0);
        t.awayOn();
        assertEquals("AWAY", t.currentState());

        t.temperatureMeasured(62.0);  // below ecoLow => heat
        assertTrue(t.isHeating());
        assertFalse(t.isCooling());

        t.temperatureMeasured(78.0);  // above ecoHigh => cool
        assertTrue(t.isCooling());
        assertFalse(t.isHeating());

        t.temperatureMeasured(70.0);  // inside eco band => off
        assertFalse(t.isHeating());
        assertFalse(t.isCooling());
    }

    @Test
    void power_loss_goes_off_and_restores_to_idle() {
        Thermostat t = new Thermostat(70.0, 1.0, 60.0, 78.0);
        t.temperatureMeasured(68.0);  // HEATING
        t.powerLost();
        assertEquals("OFF", t.currentState());

        // events ignored while off
        t.temperatureMeasured(10.0);
        t.awayOn();
        t.setTarget(65.0);
        assertEquals("OFF", t.currentState());

        t.powerRestored();
        assertEquals("IDLE", t.currentState());
    }
}
