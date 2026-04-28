package cs680.hw15;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class LaundryMachineTest {

    @Test
    public void testLambdaObservers() {

        LaundryMachine machine = new LaundryMachine("Washer-1");

        StringBuilder log = new StringBuilder();

        // Observer 1: Mobile notification (lambda)
        machine.addObserver(event ->
            log.append("Mobile: ")
               .append(event.getMachineName())
               .append(" ")
               .append(event.getStatus())
               .append("\n")
        );

        // Observer 2: Wall display (lambda)
        machine.addObserver(event ->
            log.append("Display: ")
               .append(event.getStatus())
               .append("\n")
        );

        machine.setStatus("RUNNING");
        machine.setStatus("DONE");

        String output = log.toString();

        assertTrue(output.contains("RUNNING"));
        assertTrue(output.contains("DONE"));
    }
}
