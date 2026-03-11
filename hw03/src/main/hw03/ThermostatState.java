package hw03;

public interface ThermostatState {
    void temperatureMeasured(Thermostat ctx, double current);
    void setTarget(Thermostat ctx, double newTarget);
    void awayOn(Thermostat ctx);
    void awayOff(Thermostat ctx);
    void powerLost(Thermostat ctx);
    void powerRestored(Thermostat ctx);
    String name();
}
