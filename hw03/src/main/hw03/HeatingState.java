package hw03;

final class HeatingState implements ThermostatState {
    @Override public void temperatureMeasured(Thermostat ctx, double current) {
        // Stop heating once we reach the target (or slightly above due to sensor noise)
        if (current >= ctx.target() - 1e-6) {
            ctx.allOff();
            ctx.changeState(new IdleState());
        } else {
            ctx.heatOn(); // keep heating
        }
    }
    @Override public void setTarget(Thermostat ctx, double t) { ctx.setTargetValue(t); }
    @Override public void awayOn(Thermostat ctx) { ctx.allOff(); ctx.changeState(new AwayState()); }
    @Override public void awayOff(Thermostat ctx) { /* already normal */ }
    @Override public void powerLost(Thermostat ctx) { ctx.allOff(); ctx.changeState(new OffState()); }
    @Override public void powerRestored(Thermostat ctx) { /* ignore */ }
    @Override public String name() { return "HEATING"; }
}
