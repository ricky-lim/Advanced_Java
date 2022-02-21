package concurrency.locks;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import java.util.stream.IntStream;

public class LocksDemo {
    private Counter counter = new Counter();
    private SyncCounter syncCounter = new SyncCounter();
    private LockedCounter lockedCounter = new LockedCounter();
    private AtomicCounter atomicCounter = new AtomicCounter();

    public static void main(String[] args) {
        LocksDemo locksDemo = new LocksDemo();
        locksDemo.demoCounter();
        locksDemo.demoSyncCounter();
        locksDemo.demoLockedCounter();
        locksDemo.demoAtomicCounter();
    }

    public void demoCounter() {
        ExecutorService service = Executors.newCachedThreadPool();
        IntStream.range(0, 1000)
                .forEach(i -> service.submit(counter::increment));
        System.out.println("Total counter: " + counter.getCount());
        service.shutdown();
    }

    public void demoSyncCounter() {
        ExecutorService service = Executors.newCachedThreadPool();
        IntStream.range(0, 1000)
                .forEach(i -> service.submit(syncCounter::increment));
        System.out.println("Total sync counter: " + syncCounter.getCount());
        service.shutdown();
    }

    public void demoLockedCounter() {
        ExecutorService service = Executors.newCachedThreadPool();
        IntStream.range(0, 1000)
                .forEach(i -> service.submit(lockedCounter::increment));
        System.out.println("Total locked counter " + lockedCounter.getCount());
        service.shutdown();
    }

    public void demoAtomicCounter() {
        ExecutorService service = Executors.newCachedThreadPool();
        IntStream.range(0, 1000)
                .forEach( i -> service.submit(atomicCounter::increment));
        System.out.println("Total atomic counter " + atomicCounter.getCount());
    }
}
