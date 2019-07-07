package codewars.threadedcounting;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class ThreadedCounting {
    public static void countInThreads(Counter counter) {
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        AtomicInteger atomicInteger = new AtomicInteger(1);
        for (int i = 0; i < 3; i++) {
            executorService.execute(getThreadModulo(i, atomicInteger, counter));
        }
        executorService.shutdown();
        try {
            executorService.awaitTermination(1, TimeUnit.MINUTES);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private static Runnable getThreadModulo(int remainder, AtomicInteger atomicInteger, Counter counter) {
        return () -> {
            int value;
            while ((value = atomicInteger.get()) <= 100) {
                synchronized (atomicInteger) {
                    if (value % 3 == remainder) {
                        counter.count(atomicInteger.getAndIncrement());
                    }
                }
            }
        };
    }
}