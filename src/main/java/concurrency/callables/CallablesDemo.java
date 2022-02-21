package concurrency.callables;

import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CallablesDemo {
    public static void main(String[] args) {
        List<MyCallable> callables = Stream.iterate(0, n -> n + 1)
                .map(MyCallable::new)
                .limit(10)
                .collect(Collectors.toList());

        ExecutorService service = Executors.newFixedThreadPool(3);

        try {
            List<Future<String>> futures = service.invokeAll(callables);
            for (Future<String> future : futures) {
                System.out.println(future.get());
            }
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }
}
