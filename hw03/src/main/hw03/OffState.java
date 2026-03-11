package hw03;

final class OffState implements ThermostatState {
    @Override public void temperatureMeasured(Thermostat ctx, double current) { /* ignore while off */ }
    @Override public void setTarget(Thermostat ctx, double t) { /* ignore while off */ }
    @Override public void awayOn(Thermostat ctx) { /* ignore while off */ }
    @Override public void awayOff(Thermostat ctx) { /* ignore while off */ }
    @Override public void powerLost(Thermostat ctx) { /* already off */ }
    @Override public void powerRestored(Thermostat ctx) { ctx.changeState(new IdleState()); }
    @Override public String name() { return "OFF"; }
}
