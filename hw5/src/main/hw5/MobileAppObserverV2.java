package hw5;

public class MobileAppObserverV2 implements StatusObserver, EnergyObserver {
    @Override
    public void onStatus(StatusEvent event) {
        System.out.println("Mobile \u2022 M" + event.getMachineId() + " -> " + event.getStatus());
    }
    @Override
    public void onEnergy(EnergyEvent event) {
        System.out.println("Mobile \u2022 M" + event.getMachineId() + " -> " + event.getWatts() + "W");
    }
}

