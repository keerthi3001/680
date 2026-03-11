package hw03;

final class AwayState implements ThermostatState {
    @Override public void temperatureMeasured(Thermostat ctx, double current) {
        // Eco band control: heat if below ecoLow, cool if above ecoHigh, otherwise off
        if (current < ctx.ecoLow()) {
            ctx.heatOn();
        } else if (current > ctx.ecoHigh()) {
            ctx.coolOn();
        } else {
            ctx.allOff();
        }
    }
    @Override public void setTarget(Thermostat ctx, double t) { ctx.setTargetValue(t); /* stay in Away */ }
    @Override public void awayOn(Thermostat ctx) { /* already away */ }
    @Override public void awayOff(Thermostat ctx) { ctx.allOff(); ctx.changeState(new IdleState()); }
    @Override public void powerLost(Thermostat ctx) { ctx.allOff(); ctx.changeState(new OffState()); }
    @Override public void powerRestored(Thermostat ctx) { /* ignore */ }
    @Override public String name() { return "AWAY"; }
}
