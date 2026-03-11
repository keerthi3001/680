package hw02;

import java.util.LinkedList;
import java.util.List;


public class SingletonPrimeGenerator {

    private static SingletonPrimeGenerator instance = null;

    private long from;
    private long to;
    private final LinkedList<Long> primes = new LinkedList<>();

    
    private SingletonPrimeGenerator() { }

    public static SingletonPrimeGenerator getInstance() {
        if (instance == null) {
            instance = new SingletonPrimeGenerator();
        }
        return instance;
    }

   
    public void setRange(long from, long to) {
        this.from = from;
        this.to = to;
    }

    public void generatePrimes() {
        validate();
        primes.clear();

        if (to < 2) return;
        long start = Math.max(2, from);

        if (start <= 2 && 2 <= to) primes.add(2L);
        if (start <= 3 && 3 <= to) primes.add(3L);

        long n = alignTo6kPlusMinus1(Math.max(start, 5));
        for (; n <= to; n += stepFor6k(n)) {
            if (isPrime6k(n)) primes.add(n);
        }
    }

    public List<Long> getPrimes() {
        return new LinkedList<>(primes);
    }


    private void validate() {
        if (from > to)
            throw new IllegalArgumentException("from must be <= to");
        if (from < 0 || to < 0)
            throw new IllegalArgumentException("range must be non-negative");
    }

    private long alignTo6kPlusMinus1(long n) {
        long r = n % 6;
        if (r == 0) return n + 1;
        if (r == 1) return n;
        if (r == 2) return n + 3;
        if (r == 3) return n + 2;
        if (r == 4) return n + 1;
        return n;
    }

    private long stepFor6k(long n) {
        return (n % 6 == 1) ? 4 : 2;
    }

    private boolean isPrime6k(long n) {
        if (n < 2) return false;
        if ((n & 1) == 0) return n == 2;
        if (n % 3 == 0) return n == 3;
        long limit = (long) Math.sqrt(n);
        for (long f = 5; f <= limit; f += 6) {
            if (n % f == 0 || n % (f + 2) == 0) return false;
        }
        return true;
    }
}
