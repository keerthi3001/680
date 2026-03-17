package hw4;

public class WallDisplayObserver implements LaundryObserver {
    @Override
    public void update(Observable<LaundryEvent> sender, LaundryEvent event) {
        System.out.println("Wall Display — Machine " +
                event.getMachineId() + " : " + event.getStatus());
    }
}
