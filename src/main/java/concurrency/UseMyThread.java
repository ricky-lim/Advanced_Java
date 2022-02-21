package concurrency;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class UseMyThread {
    public static void main(String[] args) {
        List<Thread> threads = Stream.iterate(0, i -> i + 1)
                .map(MyThread::new)
                .limit(10)
                .collect(Collectors.toList());

        threads.forEach(Thread::start);
    }
}
