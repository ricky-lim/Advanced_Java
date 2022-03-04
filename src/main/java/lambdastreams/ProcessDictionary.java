package lambdastreams;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Comparator;
import java.util.Optional;

public class ProcessDictionary {
    public static void main(String[] args) throws IOException {
        Files.lines(Paths.get("/", "usr", "share", "dict", "web2"))
                .filter( word -> word.length() > 10)
                .map(String::toLowerCase)
                .sorted(Comparator.comparingInt(String::length).reversed())
                .limit(10)
                .forEach((String word) -> System.out.printf("%s (%d) %n", word, word.length()));

        Optional<String> max = Files.lines(Paths.get("/", "usr", "share", "dict", "web2"))
                .filter(word -> word.length() > 10)
                .map(String::toLowerCase)
                .sorted(Comparator.comparingInt(String::length).reversed())
                .findFirst();

        max.ifPresent(s -> System.out.printf("%s (%d) %n", s, s.length()));
        System.out.println(max.orElseGet(() -> "nothing"));
        System.out.println(max.orElse("nothing"));



    }
}
