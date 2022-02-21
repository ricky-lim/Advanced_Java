package concurrency.callables;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.concurrent.*;
import java.util.stream.Collectors;

public class FileLinesCounter {
    private final Path dir = Paths.get("src", "main", "java", "concurrency");

    public static void main(String[] args) throws IOException, InterruptedException {
        FileLinesCounter fileLinesCounter = new FileLinesCounter();
        long lineTotal = fileLinesCounter.computeTotalLines();
        System.out.printf("Total number of lines: %s%n", lineTotal);
    }

    private long computeTotalLines() throws IOException, InterruptedException {
        return executeCounters().stream()
                .mapToLong(this::extractValueFromFuture)
                .sum();
    }

    private List<Future<Long>> executeCounters() throws InterruptedException, IOException {

        ExecutorService service = Executors.newCachedThreadPool();
        List<Future<Long>> futures = service.invokeAll(getFileLineCounters());
        service.shutdown();

        return futures;
    }

    private List<Callable<Long>> getFileLineCounters() throws IOException {
        return Files.list(dir)
                .filter(Files::isRegularFile)
                .map(this::callablePrintingCounter)
                .collect(Collectors.toList());
    }

    private Callable<Long> callablePrintingCounter(Path path) {
        return () -> {
            long total = countLine(path);
            System.out.printf("%s: %s%n", path.getFileName(), total);
            return total;
        };
    }

    private long countLine(Path path) throws IOException {
        return Files.lines(path).count();
    }

    private <T> T extractValueFromFuture(Future<T> future) {
        T val = null;
        try {
            val = future.get();
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
        return val;
    }

}
