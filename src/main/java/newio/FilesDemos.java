package newio;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FilesDemos {
    public static void main(String[] args) throws IOException {
//        Files.createDirectory(Paths.get("data"));

        Path sourceDir = Paths.get("src", "main", "java","newio");
        Path dataFile = sourceDir.resolve("data.txt");
//        List<String> content = Files.lines(dataFile).collect(Collectors.toList());
//        System.out.println(content);
        Files.lines(dataFile)
                .forEach(System.out::println);

        Path destination = sourceDir.resolve("data_copy.txt");
        Files.deleteIfExists(destination);
        Files.copy(dataFile, destination);

        Path javaDir = Paths.get("src", "main", "java");
        try (Stream<Path> entries = Files.walk(javaDir)){
            entries.filter(Files::isDirectory)
                    .forEach(System.out::println);
        }

        long numberOfFiles = Files.walk(javaDir)
                .filter(Files::isRegularFile)
                .count();
        System.out.println("Number of java file: " + numberOfFiles);

    }
}
