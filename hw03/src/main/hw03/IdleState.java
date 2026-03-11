package hw03;

final class IdleState implements ThermostatState {
    @Override public void temperatureMeasured(Thermostat ctx, double current) {
        if (current < ctx.target() - ctx.deadband()) {
            ctx.heatOn();
            ctx.changeState(new HeatingState());
        } else if (current > ctx.target() + ctx.deadband()) {
            ctx.coolOn();
            ctx.changeState(new CoolingState());
        } else {
            ctx.allOff(); 
        }
    }
    @Override public void setTarget(Thermostat ctx, double t) { ctx.setTargetValue(t); }
    @Override public void awayOn(Thermostat ctx) { ctx.allOff(); ctx.changeState(new AwayState()); }
    @Override public void awayOff(Thermostat ctx) { /* already normal */ }
    @Override public void powerLost(Thermostat ctx) { ctx.allOff(); ctx.changeState(new OffState()); }
    @Override public void powerRestored(Thermostat ctx) { /* ignore */ }
    @Override public String name() { return "IDLE"; }
}
