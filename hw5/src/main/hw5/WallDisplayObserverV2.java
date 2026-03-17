package hw5;

public class WallDisplayObserverV2 implements StatusObserver {
    @Override
    public void onStatus(StatusEvent event) {
        System.out.println("Wall • Machine " + event.getMachineId() + " : " + event.getStatus());
    }
}
