package hw03;

public class Thermostat {
    
    private double target;            
    private final double deadband;    
    private final double ecoLow;      
    private final double ecoHigh;     

    
    private ThermostatState state;
    private boolean heaterOn = false;
    private boolean acOn = false;

    public Thermostat(double initialTarget, double deadband, double ecoLow, double ecoHigh) {
        if (deadband <= 0 || ecoLow >= ecoHigh) {
            throw new IllegalArgumentException("Invalid thermostat configuration.");
        }
        this.target = initialTarget;
        this.deadband = deadband;
        this.ecoLow = ecoLow;
        this.ecoHigh = ecoHigh;
        changeState(new IdleState());
    }

    void changeState(ThermostatState s) { this.state = s; }

    
    public void temperatureMeasured(double current) { state.temperatureMeasured(this, current); }
    public void setTarget(double newTarget)        { state.setTarget(this, newTarget); }
    public void awayOn()                           { state.awayOn(this); }
    public void awayOff()                          { state.awayOff(this); }
    public void powerLost()                        { state.powerLost(this); }
    public void powerRestored()                    { state.powerRestored(this); }

   
    void heatOn()  { heaterOn = true;  acOn = false; }
    void coolOn()  { acOn = true;      heaterOn = false; }
    void allOff()  { heaterOn = false; acOn = false; }

    
    public String currentState() { return state.name(); }
    public double target()       { return target; }
    public void setTargetValue(double t) { this.target = t; }
    public double deadband()     { return deadband; }
    public double ecoLow()       { return ecoLow; }
    public double ecoHigh()      { return ecoHigh; }
    public boolean isHeating()   { return heaterOn; }
    public boolean isCooling()   { return acOn; }
}
