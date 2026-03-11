package hw1;

import java.util.LinkedList;

public class PrimeGenerator {
    private final long from;
    private final long to;
    private final LinkedList<Long> primes = new LinkedList<>();

    public PrimeGenerator(long from, long to) {
        if (from < 1 || to < 1 || to < from) {
            throw new IllegalArgumentException("Bad range: from=" + from + ", to=" + to);
        }
        this.from = from;
        this.to = to;
    }

    public void generatePrimes() {
        primes.clear();
        if (to < 2) return;
        int upper = (int) to;
        boolean[] composite = sieve(upper);
        int start = (int) Math.max(2, from);
        for (int n = start; n <= upper; n++) {
            if (!composite[n]) primes.add((long) n);
        }
    }

    public LinkedList<Long> getPrimes() {
        return primes;
    }

    private boolean[] sieve(int upper) {
        boolean[] composite = new boolean[upper + 1];
        if (upper >= 0) composite[0] = true;
        if (upper >= 1) composite[1] = true;
        int limit = (int) Math.sqrt(upper);
        for (int p = 2; p <= limit; p++) {
            if (!composite[p]) {
                for (int m = p * p; m <= upper; m += p) composite[m] = true;
            }
        }
        return composite;
    }
}
